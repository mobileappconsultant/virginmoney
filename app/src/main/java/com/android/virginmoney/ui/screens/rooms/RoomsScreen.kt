package com.android.virginmoney.ui.screens.rooms

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.ui.composable.ErrorPage
import com.android.virginmoney.ui.composable.FullScreenProgress
import com.android.virginmoney.ui.screens.rooms.viewmodels.RoomUiState

@ExperimentalCoilApi
@Composable
fun RoomsScreen(roomUiState: RoomUiState) {
    when {
        roomUiState.isLoading -> FullScreenProgress(modifier = Modifier.fillMaxSize())
        roomUiState.rooms.isEmpty() -> ErrorPage(message = roomUiState.message) {
        }
        else -> RoomsList(roomUiState.rooms)
    }
}
