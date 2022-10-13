package com.android.people.data.repository.remote

import com.android.people.data.remote.model.UsersDto
import com.android.core.utils.ApiResult

interface RemoteRepository {
    suspend fun getUsers(): ApiResult<UsersDto>
}
