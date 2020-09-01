package com.esq.gads2020practiceproject1.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.viewmodel.LearningLeaderViewModel

class LearningLeaderFragment : Fragment() {
    val TAG = this::class.simpleName

    companion object {
        @JvmStatic
        fun newInstance() =
            LearningLeaderFragment()
    }

    private lateinit var viewModel: LearningLeaderViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.learning_leader_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(LearningLeaderViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })
    }

}
