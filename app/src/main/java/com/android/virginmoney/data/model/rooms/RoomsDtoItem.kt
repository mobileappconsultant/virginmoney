package com.android.virginmoney.data.model.rooms

import com.google.gson.annotations.SerializedName
import org.joda.time.DateTime

data class RoomsDtoItem(
    @SerializedName("createdAt")
    val createdAt: DateTime,
    @SerializedName("id")
    val id: String,
    @SerializedName("isOccupied")
    val isOccupied: Boolean,
    @SerializedName("maxOccupancy")
    val maxOccupancy: Int
)
