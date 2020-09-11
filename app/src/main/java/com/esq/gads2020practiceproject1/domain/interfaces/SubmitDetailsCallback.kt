package com.esq.gads2020practiceproject1.domain.interfaces

interface SubmitDetailsCallback {
    fun onValidationError(errorMessage: String, errorCode: Int)
    fun onSubmitSuccess(successMsg: String)
    fun onSubmitError(errorMessage: String)

}