package com.esq.gads2020practiceproject1.viewmodel

import androidx.lifecycle.*
import com.esq.gads2020practiceproject1.data.Repository
import com.esq.gads2020practiceproject1.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.IOException

class LearningLeaderViewModel : ViewModel() {
    private val repo by lazy { Repository() }

    val learningLeaders = liveData {
        viewModelScope.launch (Dispatchers.IO){
            emit(Resource.loading(null))
            try {
                emit(Resource.success(repo.getListOfLearningLeaders()))
            } catch (e: IOException) {
                emit(Resource.error(e.message!!, data = null))
            }
        }
    }
}
