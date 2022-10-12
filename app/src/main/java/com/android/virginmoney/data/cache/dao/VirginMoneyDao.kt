package com.android.virginmoney.data.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.cache.entity.UserEntity

@Dao
interface VirginMoneyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRooms(entities: List<RoomEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(entities: List<UserEntity>)

    @Query("SELECT * from rooms")
    suspend fun getRooms(): List<RoomEntity>

    @Query("SELECT * from users")
    suspend fun getUsers(): List<UserEntity>
}
