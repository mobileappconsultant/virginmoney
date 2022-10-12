package com.android.virginmoney.data.api

import com.android.virginmoney.data.model.people.UsersDto
import com.android.virginmoney.data.model.rooms.RoomsDto
import retrofit2.http.GET

interface VirginMoneyApi {
    @GET("api/v1/people")
    suspend fun getUsers(): UsersDto

    @GET("api/v1/rooms")
    suspend fun getRooms(): RoomsDto
}
