package com.esq.gads2020practiceproject1.data

import com.esq.gads2020practiceproject1.domain.network.RetrofitApi

class Repository {

    suspend fun getListOfLearningLeaders() = RetrofitApi.client.getLearningLeaders()

    suspend fun getListOfSkillLeaders() = RetrofitApi.client.getSkillLeaders()

}