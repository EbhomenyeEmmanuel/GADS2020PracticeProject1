package com.esq.gads2020practiceproject1.data

import com.esq.gads2020practiceproject1.domain.LeaderDataModel
import com.esq.gads2020practiceproject1.domain.SkillDataModel
import com.esq.gads2020practiceproject1.domain.network.RetrofitApi

class Repository {

    suspend fun getListOfLearningLeaders(): List<LeaderDataModel> =
        RetrofitApi.client.getLearningLeaders()

    suspend fun getListOfSkillLeaders(): List<SkillDataModel> =
        RetrofitApi.client.getSkillLeaders()

}