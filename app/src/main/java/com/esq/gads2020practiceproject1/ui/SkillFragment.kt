package com.esq.gads2020practiceproject1.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.viewmodel.SkillViewModel

class SkillFragment : Fragment(R.layout.skill_fragment) {
    val TAG = this::class.simpleName

    companion object {
        fun newInstance() = SkillFragment()
    }

    private lateinit var viewModel: SkillViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel = ViewModelProvider(this).get(SkillViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer<String> {
            //textView.text = it
        })
        super.onViewCreated(view, savedInstanceState)
    }

}
