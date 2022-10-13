package com.android.people.utils

import com.android.rooms.data.local.entity.RoomEntity
import com.android.rooms.data.remote.model.RoomsDtoItem
import com.android.rooms.domain.model.Room
import org.joda.time.DateTime

object MockUtils {

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
