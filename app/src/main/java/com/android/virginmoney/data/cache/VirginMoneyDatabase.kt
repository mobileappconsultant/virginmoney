package com.android.virginmoney.data.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.virginmoney.data.cache.dao.VirginMoneyDao
import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.cache.entity.UserEntity

@Database(entities = [UserEntity::class, RoomEntity::class], version = 1, exportSchema = false)
abstract class VirginMoneyDatabase : RoomDatabase() {
    abstract fun virginMoneyDao(): VirginMoneyDao
}
