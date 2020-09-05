package com.esq.gads2020practiceproject1.domain.interfaces

import com.esq.gads2020practiceproject1.domain.LeaderDataModel
import com.esq.gads2020practiceproject1.domain.SkillDataModel
import retrofit2.http.GET

interface ApiInterface {

    @GET("/api/hours/")
    suspend fun getLearningLeaders(): List<LeaderDataModel>

    @GET("/api/skilliq/")
    suspend fun getSkillLeaders(): List<SkillDataModel>
}