package com.android.rooms.data.repository.remote

import com.android.core.utils.ApiResult
import com.android.core.utils.apiResult
import com.android.rooms.data.remote.RoomsApi
import com.android.rooms.data.remote.model.RoomsDto
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val roomsApi: RoomsApi) :
    RemoteRepository {
    override suspend fun getRooms(): ApiResult<RoomsDto> = apiResult {
        roomsApi.getRooms()
    }
}
