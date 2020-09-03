package com.esq.gads2020practiceproject1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.viewmodel.LearningLeaderViewModel

class LearningLeaderFragment : Fragment(R.layout.learning_leader_fragment) {
    val TAG = this::class.simpleName

    companion object {
        @JvmStatic
        fun newInstance() =
            LearningLeaderFragment()
    }

    private lateinit var viewModel: LearningLeaderViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LearningLeaderViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer<String> {
            // textView.text = it
        })
    }

}
