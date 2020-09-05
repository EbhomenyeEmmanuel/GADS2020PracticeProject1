package com.esq.gads2020practiceproject1.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.data.SkillAdapter
import com.esq.gads2020practiceproject1.utils.Status
import com.esq.gads2020practiceproject1.utils.longToast
import com.esq.gads2020practiceproject1.utils.shortToast
import com.esq.gads2020practiceproject1.viewmodel.SkillViewModel
import kotlinx.android.synthetic.main.skill_fragment.*

class SkillFragment : Fragment(R.layout.skill_fragment) {
    val TAG = this::class.simpleName
lateinit var skillAdapter: SkillAdapter

    companion object {
        fun newInstance() = SkillFragment()
    }

    private lateinit var viewModel: SkillViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)
        activity?.initSkillAdapter()
    }

    private fun Context.initSkillAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        skillRv!!.layoutManager = layoutManager
        viewModel.skillLeaders.observe(viewLifecycleOwner, Observer {
            it.let { resource ->
                when (resource.status) {
                    Status.LOADING -> {
                        shortToast("Loading")
                        Log.d(TAG, "Status.LOADING: Loading")
                    }
                    Status.SUCCESS -> {
                        shortToast("Success")
                        Log.d(TAG, "Status.SUCCESS: Success")
                        Log.d(TAG, " Items observed is ${it.data}")
                        skillAdapter =
                            SkillAdapter(
                                this,
                                it.data!!
                            )
                       skillRv.setAdapter(skillAdapter)
                    }
                    Status.ERROR -> {
                        longToast("Error!!!")
                        Log.d(TAG, "Status.ERROR: Failed")
                    }
                }
            }
        })
    }
}
