package com.android.virginmoney.data.repository.remote

import com.android.virginmoney.data.api.VirginMoneyApi
import com.android.virginmoney.data.model.people.UsersDto
import com.android.virginmoney.data.model.rooms.RoomsDto
import com.android.virginmoney.utils.ApiResult
import com.android.virginmoney.utils.apiResult
import javax.inject.Inject

class RemoteRepositoryImpl @Inject constructor(private val virginMoneyApi: VirginMoneyApi) : RemoteRepository {
    override suspend fun getRooms(): ApiResult<RoomsDto> = apiResult {
        virginMoneyApi.getRooms()
    }

    override suspend fun getUsers(): ApiResult<UsersDto> = apiResult {
        virginMoneyApi.getUsers()
    }
}
