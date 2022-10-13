package com.android.people.data.repository.remote

import com.android.core.utils.ApiResult
import com.android.core.utils.apiResult
import com.android.people.data.remote.UsersApi
import com.android.people.data.remote.model.UsersDto
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val usersApi: UsersApi) : RemoteRepository {

    override suspend fun getUsers(): ApiResult<UsersDto> = apiResult {
        usersApi.getUsers()
    }
}
