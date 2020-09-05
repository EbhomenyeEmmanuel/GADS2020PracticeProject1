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
import com.esq.gads2020practiceproject1.data.LeaderAdapter
import com.esq.gads2020practiceproject1.utils.Status
import com.esq.gads2020practiceproject1.utils.longToast
import com.esq.gads2020practiceproject1.utils.shortToast
import com.esq.gads2020practiceproject1.viewmodel.LearningLeaderViewModel
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.learning_leader_fragment.*

class LearningLeaderFragment : Fragment(R.layout.learning_leader_fragment) {
    val TAG = this::class.simpleName
    lateinit var leaderAdapter: LeaderAdapter

    companion object {
        @JvmStatic
        fun newInstance() =
            LearningLeaderFragment()
    }

    private lateinit var viewModel: LearningLeaderViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LearningLeaderViewModel::class.java)
        activity?.initLeaderAdapter()
    }

    private fun Context.initLeaderAdapter() {
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        leaderRv!!.layoutManager = layoutManager
        viewModel.learningLeaders.observe(viewLifecycleOwner, Observer {
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
                        leaderAdapter =
                            LeaderAdapter(
                                this,
                                it.data!!
                            )
                        leaderRv.setAdapter(leaderAdapter)
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

