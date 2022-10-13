package com.android.rooms.domain.mapper

import com.android.core.mapper.Mapper
import com.android.core.utils.Constants.DATE_FORMAT
import com.android.rooms.data.local.entity.RoomEntity
import com.android.rooms.data.remote.model.RoomsDtoItem
import com.android.rooms.domain.model.Room
import javax.inject.Inject

class RoomMapper @Inject constructor() : Mapper<RoomEntity, RoomsDtoItem, Room> {
    override fun toEntity(value: RoomsDtoItem) = RoomEntity(
        id = value.id,
        isOccupied = value.isOccupied,
        maxOccupancy = value.maxOccupancy,
        createdAt = value.createdAt.toString(DATE_FORMAT),
    )

    override fun toItem(value: RoomEntity) = Room(
        id = value.id,
        isOccupied = value.isOccupied,
        maxOccupancy = value.maxOccupancy,
        createdAt = value.createdAt,
    )
}
