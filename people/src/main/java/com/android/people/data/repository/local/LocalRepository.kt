package com.android.people.data.repository.local

import com.android.people.data.local.entity.UserEntity

interface LocalRepository {
    suspend fun getUsers(): List<UserEntity>
    suspend fun insertUsers(entities: List<UserEntity>)
}
