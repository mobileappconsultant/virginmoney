package com.android.virginmoney.data.repository.local

import com.android.virginmoney.data.cache.dao.VirginMoneyDao
import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.cache.entity.UserEntity
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(private val virginMoneyDao: VirginMoneyDao) : LocalRepository {
    override suspend fun getRooms(): List<RoomEntity> = virginMoneyDao.getRooms()

    override suspend fun getUsers(): List<UserEntity> = virginMoneyDao.getUsers()

    override suspend fun insertRooms(entities: List<RoomEntity>) = virginMoneyDao.insertRooms(entities)

    override suspend fun insertUsers(entities: List<UserEntity>) = virginMoneyDao.insertUsers(entities)
}
