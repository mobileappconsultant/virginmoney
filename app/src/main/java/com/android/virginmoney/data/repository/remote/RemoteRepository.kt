package com.android.virginmoney.data.repository.remote

import com.android.virginmoney.data.model.people.UsersDto
import com.android.virginmoney.data.model.rooms.RoomsDto
import com.android.virginmoney.utils.ApiResult

interface RemoteRepository {
    suspend fun getRooms(): ApiResult<RoomsDto>
    suspend fun getUsers(): ApiResult<UsersDto>
}
