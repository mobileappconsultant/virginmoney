package com.android.virginmoney.data.cache.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "rooms")
data class RoomEntity(
    @PrimaryKey
    val id: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int,
    val createdAt: String
)
