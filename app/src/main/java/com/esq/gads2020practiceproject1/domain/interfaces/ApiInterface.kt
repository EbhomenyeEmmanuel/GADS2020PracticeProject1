package com.esq.gads2020practiceproject1.domain.interfaces

import retrofit2.http.GET
import retrofit2.http.Header

interface ApiInterface {

    @GET("/api/hourst/")
    suspend fun getLearningLeaders(): Any

    @GET("/loanapi/loanactivelist/")
    suspend fun getSkillLeaders(): Any
}