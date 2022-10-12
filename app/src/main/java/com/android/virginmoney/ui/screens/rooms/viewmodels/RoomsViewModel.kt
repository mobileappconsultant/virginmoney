package com.android.virginmoney.ui.screens.rooms.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.virginmoney.domain.model.Room
import com.android.virginmoney.domain.usecase.GetRoomsUseCase
import com.android.virginmoney.utils.DispatcherProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class RoomsViewModel @Inject constructor(
    private val getRoomsUseCase: GetRoomsUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow(RoomUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getRooms()
    }

    fun getRooms() = viewModelScope.launch(dispatcherProvider.io) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        val roomsData = getRoomsUseCase.execute()
        val showErrorScreen = roomsData.errorMessage != null && roomsData.data.isNullOrEmpty()
        val (occupied, empty) = roomsData.data?.let {
            it.partition { it.isOccupied }
        } ?: Pair(emptyList(), emptyList())
        _uiState.update {
            it.copy(
                isLoading = false,
                rooms = roomsData.data.orEmpty(),
                showErrorScreen = showErrorScreen,
                emptyRoomCount = empty.size,
                occupiedRoomCount = occupied.size
            )
        }
    }
}

data class RoomUiState(
    val isLoading: Boolean = false,
    val rooms: List<Room> = emptyList(),
    val showErrorScreen: Boolean = false,
    val message: String = "",
    val emptyRoomCount: Int = 0,
    val occupiedRoomCount: Int = 0
)
