package com.android.virginmoney.ui.screens.users

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.ui.composable.ErrorPage
import com.android.virginmoney.ui.composable.FullScreenProgress
import com.android.virginmoney.ui.screens.users.viewmodels.UsersUiState

@ExperimentalCoilApi
@Composable
fun UsersScreen(uiState: UsersUiState) {

    when {
        uiState.isLoading -> FullScreenProgress(modifier = Modifier.fillMaxSize())
        uiState.users.isEmpty() -> ErrorPage(message = uiState.message) {
        }
        else -> UsersList(uiState.users)
    }
}
