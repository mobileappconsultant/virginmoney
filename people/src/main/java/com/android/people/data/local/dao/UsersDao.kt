package com.android.people.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.people.data.local.entity.UserEntity

@Dao
interface UsersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUsers(entities: List<UserEntity>)

    @Query("SELECT * from users")
    suspend fun getUsers(): List<UserEntity>
}
