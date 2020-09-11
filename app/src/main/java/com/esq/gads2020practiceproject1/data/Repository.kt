package com.esq.gads2020practiceproject1.data

import com.esq.gads2020practiceproject1.domain.LeaderDataModel
import com.esq.gads2020practiceproject1.domain.SkillDataModel
import com.esq.gads2020practiceproject1.api.RetrofitApi

class Repository {

    suspend fun getListOfLearningLeaders(): List<LeaderDataModel> =
        RetrofitApi.client.getLearningLeaders()

    suspend fun getListOfSkillLeaders(): List<SkillDataModel> =
        RetrofitApi.client.getSkillLeaders()

    suspend fun submitMyDetails(
        email: String, name: String, lastName: String, projectLink: String
    ) {
        val fieldMaps = mutableMapOf<String, String>()
        fieldMaps["entry.1824927963"] = email
        fieldMaps["entry.1877115667"] = name
        fieldMaps["entry.2006916086"] = lastName
        fieldMaps["entry.284483984"] = projectLink
        return RetrofitApi.client.submitDetails(fieldMaps)
    }

}