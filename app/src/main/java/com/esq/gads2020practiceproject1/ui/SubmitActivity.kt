package com.esq.gads2020practiceproject1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.esq.gads2020practiceproject1.R
import com.esq.gads2020practiceproject1.databinding.ActivitySubmitBinding
import com.esq.gads2020practiceproject1.domain.interfaces.SubmitDetailsCallback
import com.esq.gads2020practiceproject1.utils.requestFocusWithErrorMessage
import com.esq.gads2020practiceproject1.viewmodel.SubmitViewModel
import com.esq.gads2020practiceproject1.viewmodel.SubmitViewModelFactory
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity(), SubmitDetailsCallback,
    AlertFragment.OnRequestConfirmationListener {
    lateinit var bind: ActivitySubmitBinding
    private val _viewModel by lazy {
        ViewModelProvider(this, SubmitViewModelFactory(this)).get(SubmitViewModel::class.java)
    }

    private val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = DataBindingUtil.setContentView(this, R.layout.activity_submit)
        bind.viewModel = _viewModel
        //showDialog()
        ibBack.setOnClickListener { this.onBackPressed() }
    }

    private fun showDialog() {
        _viewModel.loading.observe(this, Observer {
            if (it) {

            }
        })
    }

    override fun onValidationSuccess(successMessage: String) {
        Log.d(TAG, "onValidationSuccess: Form has been validated")
        AlertFragment.newInstance(successMessage)
            .show(supportFragmentManager, "")
    }

    override fun onValidationError(errorMessage: Int, errorCode: Int) {
        Log.d(TAG, "onValidationError: code: $errorCode msg: ${applicationContext.getString(errorMessage)}")
        when (errorCode) {
            1 -> {
                bind.editTextFirstName.requestFocusWithErrorMessage(applicationContext.getString(errorMessage))
            }
            2 -> {
                bind.editTextLastName.requestFocusWithErrorMessage(applicationContext.getString(errorMessage))
            }
            3 -> {
                bind.editTextEmail.requestFocusWithErrorMessage(applicationContext.getString(errorMessage))
            }
            4 -> {
                bind.editTextProjectLink.requestFocusWithErrorMessage(getString(errorMessage))
            }
        }
    }

    override fun onSubmitSuccess(successMsg: Int) {
        AlertFragment.newInstance(getString(successMsg))
            .show(supportFragmentManager, "")
        Log.d(TAG, "Submitted Successfully")
    }

    override fun onSubmitError(errorMessage: Int) {
        Log.d(TAG, "onSubmitError: ${getString(errorMessage)}")
        AlertFragment.newInstance(getString(errorMessage))
            .show(supportFragmentManager, "")
    }

    override fun onConfirmed() {
        Log.d(TAG, "onConfirmed: Called")
        _viewModel.submitDetailsCall()
    }
}
