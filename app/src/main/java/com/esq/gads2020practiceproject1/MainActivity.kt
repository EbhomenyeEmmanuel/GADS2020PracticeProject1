package com.esq.gads2020practiceproject1

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.esq.gads2020practiceproject1.data.SectionsPagerAdapter
import com.esq.gads2020practiceproject1.utils.longToast
import com.google.android.material.appbar.MaterialToolbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var mToolbar: MaterialToolbar? = null
    private var mTabLayout: TabLayout? = null
    private var mViewPager: ViewPager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolbar = toolbar
        setSupportActionBar(mToolbar)

        mViewPager = viewPager
        viewPager.adapter = SectionsPagerAdapter(supportFragmentManager)

        mTabLayout = tabs
        mTabLayout!!.setupWithViewPager(viewPager)
        mTabLayout!!.setupWithViewPager(mViewPager)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_submit -> {
                longToast("Submit")
            }}
        return super.onOptionsItemSelected(item)
    }
}