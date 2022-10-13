package com.android.rooms.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.rooms.data.local.dao.RoomsDao
import com.android.rooms.data.local.entity.RoomEntity

@Database(entities = [RoomEntity::class], version = 1, exportSchema = false)
abstract class VirginMoneyRoomsDatabase : RoomDatabase() {
    abstract fun roomsDao(): RoomsDao
}
