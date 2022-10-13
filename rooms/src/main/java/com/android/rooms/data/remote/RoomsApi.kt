package com.android.rooms.data.remote

import com.android.rooms.data.remote.model.RoomsDto
import retrofit2.http.GET

interface RoomsApi {
    @GET("api/v1/rooms")
    suspend fun getRooms(): RoomsDto
}
