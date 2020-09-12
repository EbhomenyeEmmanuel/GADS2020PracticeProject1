package com.esq.gads2020practiceproject1.domain.interfaces

interface SubmitDetailsCallback {
    fun onValidationSuccess(successMessage: String)
    fun onValidationError(errorMessage: Int, errorCode: Int)
    fun onSubmitSuccess(successMsg: Int)
    fun onSubmitError(errorMessage: Int)

}