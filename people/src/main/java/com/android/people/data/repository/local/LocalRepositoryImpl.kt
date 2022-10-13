package com.android.people.data.repository.local

import com.android.people.data.local.dao.UsersDao
import com.android.people.data.local.entity.UserEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val virginMoneyDao: UsersDao) :
    LocalRepository {

    override suspend fun getUsers(): List<UserEntity> = virginMoneyDao.getUsers()

    override suspend fun insertUsers(entities: List<UserEntity>) =
        virginMoneyDao.insertUsers(entities)
}
