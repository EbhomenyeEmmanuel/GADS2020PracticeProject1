package com.esq.gads2020practiceproject1.domain

import com.squareup.moshi.Json

data class LeaderDataModel(
    @Json(name = "name")
    private val name: String? = null,
    @Json(name = "hours")
    private val hours: Int? = null,
    @Json(name = "country")
    private val country: String? = null,
    @Json(name = "badgeUrl")
    private val badgeUrl: String? = null
)

data class  SkillDataModel(
    @Json(name = "name")
    private val name: String? = null,
    @Json(name = "score")
    private val score: Int? = null,
    @Json(name = "country")
    private val country: String? = null,
    @Json(name = "badgeUrl")
    private val badgeUrl: String? = null
)
