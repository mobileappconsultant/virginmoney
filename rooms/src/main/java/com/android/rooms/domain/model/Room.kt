package com.android.rooms.domain.model

data class Room(
    val id: String,
    val isOccupied: Boolean,
    val maxOccupancy: Int,
    val createdAt: String
)
