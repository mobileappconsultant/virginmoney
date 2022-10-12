package com.android.virginmoney.data.repository.local

import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.cache.entity.UserEntity

interface LocalRepository {
    suspend fun getRooms(): List<RoomEntity>
    suspend fun getUsers(): List<UserEntity>
    suspend fun insertRooms(entities: List<RoomEntity>)
    suspend fun insertUsers(entities: List<UserEntity>)
}
