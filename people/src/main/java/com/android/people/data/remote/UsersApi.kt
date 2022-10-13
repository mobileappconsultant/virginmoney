package com.android.people.data.remote

import com.android.people.data.remote.model.UsersDto
import retrofit2.http.GET

interface UsersApi {
    @GET("api/v1/people")
    suspend fun getUsers(): UsersDto
}
