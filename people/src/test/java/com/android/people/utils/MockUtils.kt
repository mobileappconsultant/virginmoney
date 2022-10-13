package com.android.people.utils

import com.android.people.data.local.entity.UserEntity
import com.android.people.data.remote.model.UsersDtoItem
import com.android.people.domain.model.User
import org.joda.time.DateTime

object MockUtils {
    fun createMockUser(id: String) = User(
        id = "id$id",
        avatar = "avatar$id",
        createdAt = "createdAt$id",
        email = "email$id",
        favouriteColor = "color$id",
        firstName = "Jon$id",
        fromName = null,
        jobtitle = "Worker$id",
        lastName = "Snow$id",
        to = null
    )

    fun createMockUserEntity(id: String) = UserEntity(
        id = "id$id",
        avatar = "avatar$id",
        createdAt = "createdAt$id",
        email = "email$id",
        favouriteColor = "color$id",
        firstName = "Jon$id",
        fromName = null,
        jobtitle = "Worker$id",
        lastName = "Snow$id",
        to = null
    )

    fun createUsersDtoItem(id: String) = UsersDtoItem(
        id = "id$id",
        avatar = "avatar$id",
        createdAt = DateTime.now(),
        email = "email$id",
        favouriteColor = "color$id",
        firstName = "Jon$id",
        fromName = null,
        jobtitle = "Worker$id",
        lastName = "Snow$id",
        to = null
    )
}
