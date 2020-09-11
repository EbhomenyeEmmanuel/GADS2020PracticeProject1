package com.esq.gads2020practiceproject1.viewmodel

import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.lifecycle.*
import com.esq.gads2020practiceproject1.data.Repository
import com.esq.gads2020practiceproject1.domain.SubmitDataModel
import com.esq.gads2020practiceproject1.domain.interfaces.SubmitDetailsCallback
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.io.IOException

class SubmitViewModel(
    private var submitDetailsCallback: SubmitDetailsCallback,
    private val repo: Repository,
    private val submitDataModel: SubmitDataModel
) : ViewModel() {

    private val TAG = this::class.java.simpleName

   private val _loading = MutableLiveData<Boolean>(false)
    val loading: LiveData<Boolean> = _loading

    val firstNameTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                submitDataModel.userFirstName = editable.toString().trim { it <= ' ' }
            }
        }

    val lastNameTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                submitDataModel.userLastName = editable.toString().trim { it <= ' ' }
            }
        }

    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                submitDataModel.userEmail = editable.toString().trim { it <= ' ' }
            }
        }

    val gitLinkTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun onTextChanged(
                charSequence: CharSequence,
                i: Int,
                i1: Int,
                i2: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                submitDataModel.userGitLink = editable.toString().trim { it <= ' ' }
            }
        }

    fun onSubmitClicked(view: View?) {
        when (val errorCode: Int = isValidData(submitDataModel)) {
            1,2 -> {
                submitDetailsCallback.onValidationError("Required", errorCode)
            } 3 -> {
                submitDetailsCallback.onValidationError("Invalid Email", errorCode)
            }
            4 -> {
                submitDetailsCallback.onValidationError("Invalid Link", errorCode)
            }
            5 -> {
                submitDetailsCall(submitDataModel)
            }
        }
    }

    //Validate editText
    private fun isValidData(submitDataModel: SubmitDataModel): Int {
        return if (TextUtils.isEmpty(submitDataModel.userFirstName)) {
            1
        } else if (TextUtils.isEmpty(submitDataModel.userLastName)) {
            2
        } else if (!Patterns.EMAIL_ADDRESS.matcher(submitDataModel.userEmail).matches()) {
            3
        } else if (!Patterns.WEB_URL.matcher(submitDataModel.userGitLink).matches()) {
            4
        } else 5
    }

    private fun submitDetailsCall(details: SubmitDataModel){
        Log.d(TAG, "submitDetailsCall:")
        viewModelScope.launch {
                toggleLoading(true)
                delay(1000)
                try {
                    with(details) {
                        repo.submitMyDetails(name = userFirstName, lastName = userLastName, email = userEmail, projectLink= userGitLink )
                    }
                    toggleLoading(false)
                    submitDetailsCallback.onSubmitSuccess("success")
                } catch (e: IOException) {
                    submitDetailsCallback.onSubmitError("failure")
                    toggleLoading(false)
                }
            }
        }

    private fun toggleLoading(b: Boolean) {
        _loading.value = b
    }

}

