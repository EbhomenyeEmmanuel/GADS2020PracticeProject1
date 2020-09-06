package com.esq.gads2020practiceproject1.domain.interfaces

import retrofit2.http.FieldMap
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SubmitApiInterface {

    @POST("/1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse/")
    @FormUrlEncoded
    suspend fun submitDetails(@FieldMap details: Map<String, String> )

}