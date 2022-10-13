package com.android.people.domain.mapper

import com.android.core.mapper.Mapper
import com.android.core.utils.Constants
import com.android.people.data.local.entity.UserEntity
import com.android.people.data.remote.model.UsersDtoItem
import com.android.people.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserEntity, UsersDtoItem, User> {
    override fun toEntity(value: UsersDtoItem): UserEntity = UserEntity(
        id = value.id,
        avatar = value.avatar,
        createdAt = value.createdAt.toString(Constants.DATE_FORMAT),
        email = value.email,
        favouriteColor = value.favouriteColor,
        firstName = value.firstName,
        fromName = value.fromName,
        jobtitle = value.jobtitle,
        lastName = value.lastName,
        to = value.to
    )

    override fun toItem(value: UserEntity): User = User(
        id = value.id,
        avatar = value.avatar,
        createdAt = value.createdAt,
        email = value.email,
        favouriteColor = value.favouriteColor,
        firstName = value.firstName,
        fromName = value.fromName,
        jobtitle = value.jobtitle,
        lastName = value.lastName,
        to = value.to
    )
}
