package com.esq.gads2020practiceproject1.domain

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class LeaderDataModel(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "hours")
    val hours: Int? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "badgeUrl")
    val badgeUrl: String? = null
)

@JsonClass(generateAdapter = true)
data class  SkillDataModel(
    @Json(name = "name")
    val name: String? = null,
    @Json(name = "score")
    val score: Int? = null,
    @Json(name = "country")
    val country: String? = null,
    @Json(name = "badgeUrl")
    val badgeUrl: String? = null
)

class SubmitDataModel( var userFirstName: String = "",
                       var userLastName: String = "",
                       var userEmail: String = "",  var userGitLink: String = "")