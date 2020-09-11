package com.esq.gads2020practiceproject1.domain.interfaces

import com.esq.gads2020practiceproject1.domain.LeaderDataModel
import com.esq.gads2020practiceproject1.domain.SkillDataModel
import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET("/api/hours/")
    suspend fun getLearningLeaders(): List<LeaderDataModel>

    @GET("/api/skilliq/")
    suspend fun getSkillLeaders(): List<SkillDataModel>

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse/")
    @FormUrlEncoded
    suspend fun submitDetails(@FieldMap details: Map<String, String> )

}