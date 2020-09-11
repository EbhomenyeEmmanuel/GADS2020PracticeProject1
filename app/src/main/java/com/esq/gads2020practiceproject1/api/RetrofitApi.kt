package com.esq.gads2020practiceproject1.api

import com.esq.gads2020practiceproject1.domain.interfaces.ApiInterface
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitApi {
    companion object {
        private val logInterceptor = HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }
        private val httpClient = OkHttpClient.Builder()
            .callTimeout(1, TimeUnit.MINUTES)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(logInterceptor)

        private var retrofit: Retrofit? = null

        val client: ApiInterface
            get() {
                when (retrofit) {
                    null -> retrofit = Retrofit.Builder()
                        .client(httpClient.build())
                        .addConverterFactory(MoshiConverterFactory.create())
                        .baseUrl("http://gadsapi.herokuapp.com")
                        .build()
                }

                return retrofit!!.create(ApiInterface::class.java)
            }

        val submitClient: ApiInterface
            get() {
                when (retrofit) {
                    null -> retrofit = Retrofit.Builder()
                        .client(httpClient.build())
                        .addConverterFactory(ScalarsConverterFactory.create())
                        .baseUrl("https://docs.google.com/forms/d/e/")
                        .build()
                }

                return retrofit!!.create(ApiInterface::class.java)
            }
    }
}