package com.android.rooms.data.repository.local

import com.android.rooms.data.local.dao.RoomsDao
import com.android.rooms.data.local.entity.RoomEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val roomsDao: RoomsDao) :
    LocalRepository {
    override suspend fun getRooms(): List<RoomEntity> = roomsDao.getRooms()
    override suspend fun insertRooms(entities: List<RoomEntity>) =
        roomsDao.insertRooms(entities)
}
