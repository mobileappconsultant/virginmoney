package com.android.rooms.data.repository.remote

import com.android.core.utils.ApiResult
import com.android.rooms.data.remote.model.RoomsDto

interface RemoteRepository {
    suspend fun getRooms(): ApiResult<RoomsDto>
}
