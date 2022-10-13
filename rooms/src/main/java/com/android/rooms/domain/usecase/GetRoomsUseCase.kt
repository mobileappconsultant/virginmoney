package com.android.rooms.domain.usecase

import com.android.core.utils.ApiResult
import com.android.rooms.data.repository.local.LocalRepository
import com.android.rooms.data.repository.remote.RemoteRepository
import com.android.rooms.domain.mapper.RoomMapper
import com.android.rooms.domain.model.Room
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
