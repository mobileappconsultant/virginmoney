package com.android.rooms.data.repository.local

import com.android.rooms.data.local.entity.RoomEntity

interface LocalRepository {
    suspend fun getRooms(): List<RoomEntity>
    suspend fun insertRooms(entities: List<RoomEntity>)
}
