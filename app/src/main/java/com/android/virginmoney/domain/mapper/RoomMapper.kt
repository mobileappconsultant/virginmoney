package com.android.virginmoney.domain.mapper

import com.android.virginmoney.data.cache.entity.RoomEntity
import com.android.virginmoney.data.model.rooms.RoomsDtoItem
import com.android.virginmoney.domain.model.Room
import com.android.virginmoney.utils.Constants.DATE_FORMAT
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
