package com.android.virginmoney.domain.mapper

import com.android.virginmoney.data.cache.entity.UserEntity
import com.android.virginmoney.data.model.people.UsersDtoItem
import com.android.virginmoney.domain.model.User
import javax.inject.Inject

class UserMapper @Inject constructor() : Mapper<UserEntity, UsersDtoItem, User> {
    override fun toEntity(value: UsersDtoItem): UserEntity = UserEntity(
        id = value.id,
        avatar = value.avatar,
        createdAt = value.createdAt.toString(),
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
