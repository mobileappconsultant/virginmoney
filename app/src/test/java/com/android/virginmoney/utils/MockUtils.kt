package com.android.virginmoney.utils

import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.cache.entity.UserEntity
import com.android.virginmoney.data.model.people.UsersDtoItem
import com.android.virginmoney.data.model.rooms.RoomsDtoItem
import com.android.virginmoney.domain.model.Room
import com.android.virginmoney.domain.model.User
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

    fun createMockRoom(id: String) = Room(
        id = "id$id",
        isOccupied = false,
        maxOccupancy = 6789,
        createdAt = "",
    )

    fun createMockRoomEntity(id: String) = RoomEntity(
        id = "id$id",
        isOccupied = false,
        maxOccupancy = 6789,
        createdAt = "",
    )

    fun createRoomsDtoItem(id: String) = RoomsDtoItem(
        id = "id$id",
        isOccupied = false,
        maxOccupancy = 6789,
        createdAt = DateTime.now(),
    )
}
