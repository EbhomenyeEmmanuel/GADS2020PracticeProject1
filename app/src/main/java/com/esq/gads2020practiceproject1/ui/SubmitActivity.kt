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
import com.esq.gads2020practiceproject1.utils.shortToast
import com.esq.gads2020practiceproject1.viewmodel.SubmitViewModel
import com.esq.gads2020practiceproject1.viewmodel.SubmitViewModelFactory
import kotlinx.android.synthetic.main.activity_submit.*

class SubmitActivity : AppCompatActivity(), SubmitDetailsCallback,
    AlertFragment.OnRequestConfirmationListener {
    lateinit var bind: ActivitySubmitBinding
    private val _viewModel =
        ViewModelProvider(this, SubmitViewModelFactory(this)).get(SubmitViewModel::class.java)

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

    override fun onValidationError(errorMessage: String, errorCode: Int) {

        if (errorCode == 1 || errorCode == 2) {
            bind.editTextEmail.requestFocusWithErrorMessage(errorMessage)
        } else {
            bind.editTextFirstName.requestFocusWithErrorMessage(errorMessage)
        }
    }

    override fun onSubmitSuccess(successMsg: String) {
        AlertFragment.newInstance(successMsg)
            .show(supportFragmentManager, "")
        Log.d(TAG, "Submitted Successfully")
    }

    override fun onSubmitError(errorMessage: String) {
        Log.d(TAG, errorMessage)
        AlertFragment.newInstance(errorMessage)
            .show(supportFragmentManager, "")
        shortToast(errorMessage)
    }

    override fun onConfirmed() {
        Log.d(TAG, "AlertFragment Called")
    }
}
