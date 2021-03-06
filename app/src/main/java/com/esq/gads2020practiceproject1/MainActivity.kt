package com.esq.gads2020practiceproject1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.viewpager.widget.ViewPager
import com.biodun.networkMonitorManager.NetworkState
import com.esq.gads2020practiceproject1.data.SectionsPagerAdapter
import com.esq.gads2020practiceproject1.ui.SubmitActivity
import com.esq.gads2020practiceproject1.utils.NetworkStatus
import com.esq.gads2020practiceproject1.utils.shortToast
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mTabLayout: TabLayout? = null
    private var mViewPager: ViewPager? = null
    private lateinit var networkStatus: NetworkStatus


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mViewPager = viewPager
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager)

        mTabLayout = tabs
        mTabLayout!!.setupWithViewPager(viewPager)
        mTabLayout!!.setupWithViewPager(mViewPager)
        networkStatus = NetworkStatus(this)

        submitBtn.setOnClickListener { startActivity(Intent(this@MainActivity, SubmitActivity::class.java)) }
    }

    override fun onStart() {
        super.onStart()
        networkStatus.networkMonitorManager.registerCallback()
        observeNetworkStateLiveData()
    }

    private fun observeNetworkStateLiveData() {
        networkStatus.networkMonitorManager.networkState.observe(this, Observer { network ->
            when (network) {
                is NetworkState.Available -> {
                    shortToast("Internet Available")
                }
                is NetworkState.UnAvailable -> shortToast("Internet Connection UnAvailable")
                is NetworkState.Lost -> shortToast("Internet Connection Lost")
            }
        })
    }

    override fun onStop() {
        super.onStop()
        networkStatus.networkMonitorManager.unRegisterCallback()
    }
}