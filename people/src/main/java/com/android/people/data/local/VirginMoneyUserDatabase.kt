package com.android.people.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.android.people.data.local.dao.UsersDao
import com.android.people.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class VirginMoneyUserDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}
