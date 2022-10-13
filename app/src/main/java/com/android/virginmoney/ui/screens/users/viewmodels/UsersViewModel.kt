package com.android.virginmoney.ui.screens.users.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.core.utils.DispatcherProvider
import com.android.people.domain.model.User
import com.android.people.domain.usecase.GetUsersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase,
    private val dispatcherProvider: DispatcherProvider
) : ViewModel() {
    private val _uiState = MutableStateFlow(UsersUiState())
    val uiState = _uiState.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() = viewModelScope.launch(dispatcherProvider.io) {
        _uiState.update {
            it.copy(isLoading = true)
        }
        val usersData = getUsersUseCase.execute()
        val showErrorScreen = usersData.errorMessage != null && usersData.data.isNullOrEmpty()
        _uiState.update {
            it.copy(
                isLoading = false,
                users = usersData.data.orEmpty(),
                showErrorScreen = showErrorScreen,
                message = usersData.errorMessage.orEmpty()
            )
        }
    }
}

data class UsersUiState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val showErrorScreen: Boolean = false,
    val message: String = ""
)
