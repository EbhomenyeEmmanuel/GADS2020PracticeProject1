package com.esq.gads2020practiceproject1.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.esq.gads2020practiceproject1.data.Repository
import com.esq.gads2020practiceproject1.domain.SubmitDataModel
import com.esq.gads2020practiceproject1.domain.interfaces.SubmitDetailsCallback

class SubmitViewModelFactory(
    private val submitDetailsCallback: SubmitDetailsCallback
) :
    ViewModelProvider.Factory {
       private val repo by lazy { Repository() }
        private val submitDataModel: SubmitDataModel = SubmitDataModel()

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(SubmitViewModel::class.java)) {
            SubmitViewModel(
                 submitDetailsCallback,repo, submitDataModel
            ) as T
        } else {
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}