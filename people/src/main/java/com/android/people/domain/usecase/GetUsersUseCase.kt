package com.android.people.domain.usecase

import com.android.people.data.repository.local.LocalRepository
import com.android.people.data.repository.remote.RemoteRepository
import com.android.people.domain.mapper.UserMapper
import com.android.people.domain.model.User
import com.android.core.utils.ApiResult
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val localRepository: LocalRepository,
    private val remoteRepository: RemoteRepository,
    private val userMapper: UserMapper
) {
    suspend fun execute(): Data {
        return when (val usersApiResult = remoteRepository.getUsers()) {
            is ApiResult.NetworkError -> {
                val userEntities = localRepository.getUsers()
                Data(
                    errorMessage = usersApiResult.e.message,
                    data = userEntities.map {
                        userMapper.toItem(it)
                    }
                )
            }
            is ApiResult.Success -> {
                val userEntities = usersApiResult.data.map {
                    userMapper.toEntity(it)
                }
                localRepository.insertUsers(userEntities)
                Data(
                    errorMessage = null,
                    data = userEntities.map {
                        userMapper.toItem(it)
                    }
                )
            }
        }
    }

    data class Data(
        val errorMessage: String?,
        val data: List<User>?
    )
}
