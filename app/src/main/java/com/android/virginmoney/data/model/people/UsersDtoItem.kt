package com.android.virginmoney.data.model.people

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

data class UsersDtoItem(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("createdAt")
    val createdAt: DateTime,
    @SerializedName("email")
    val email: String,
    @SerializedName("favouriteColor")
    val favouriteColor: String,
    @SerializedName("firstName")
    val firstName: String,
    @SerializedName("fromName")
    val fromName: String?,
    @SerializedName("id")
    val id: String,
    @SerializedName("jobtitle")
    val jobtitle: String,
    @SerializedName("lastName")
    val lastName: String,
    @SerializedName("to")
    val to: String?
)
