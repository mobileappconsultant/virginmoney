package com.android.virginmoney.domain.model

data class User(
    val id: String,
    val avatar: String,
    val createdAt: String,
    val email: String,
    val favouriteColor: String,
    val firstName: String,
    val fromName: String?,
    val jobtitle: String,
    val lastName: String,
    val to: String?
)
