package com.android.virginmoney.domain.usecase

import com.android.virginmoney.data.repository.local.LocalRepository
import com.android.virginmoney.data.repository.remote.RemoteRepository
import com.android.virginmoney.domain.mapper.RoomMapper
import com.android.virginmoney.domain.model.Room
import com.android.virginmoney.utils.ApiResult
import javax.inject.Inject

class GetRoomsUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val roomMapper: RoomMapper
) {
    suspend fun execute(): Data {
        return when (val roomsApiResult = remoteRepository.getRooms()) {
            is ApiResult.NetworkError -> {
                val roomEntities = localRepository.getRooms()
                Data(
                    errorMessage = roomsApiResult.e.message,
                    data = roomEntities.map {
                        roomMapper.toItem(it)
                    }
                )
            }
            is ApiResult.Success -> {
                val roomsEntity = roomsApiResult.data.map {
                    roomMapper.toEntity(it)
                }
                localRepository.insertRooms(roomsEntity)
                Data(
                    errorMessage = null,
                    data = roomsEntity.map {
                        roomMapper.toItem(it)
                    }
                )
            }
        }
    }

    data class Data(
        val errorMessage: String?,
        val data: List<Room>?
    )
}
