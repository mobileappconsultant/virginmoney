package com.android.virginmoney.ui.screens.rooms

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.domain.model.Room

@ExperimentalCoilApi
@Composable
fun RoomsList(rooms: List<Room>) {
    LazyColumn {
        items(rooms) { room ->
            RoomsListItem(room = room)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}
