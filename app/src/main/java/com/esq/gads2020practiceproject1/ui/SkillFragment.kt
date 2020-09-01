package com.esq.gads2020practiceproject1.ui

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer

import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.viewmodel.SkillViewModel

class SkillFragment : Fragment() {
    val TAG = this::class.simpleName

    companion object {
        fun newInstance() = SkillFragment()
    }

    private lateinit var viewModel: SkillViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.skill_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SkillViewModel::class.java)
        viewModel.text.observe(viewLifecycleOwner, Observer<String> {
            textView.text = it
        })    }

}
