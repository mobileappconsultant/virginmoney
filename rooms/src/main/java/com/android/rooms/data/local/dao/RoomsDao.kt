package com.android.rooms.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.rooms.data.local.entity.RoomEntity

@Dao
interface RoomsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRooms(entities: List<RoomEntity>)

    @Query("SELECT * from rooms")
    suspend fun getRooms(): List<RoomEntity>
}
