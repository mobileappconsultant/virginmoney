package com.android.virginmoney.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.android.virginmoney.ui.screens.rooms.viewmodels.RoomsViewModel
import com.android.virginmoney.ui.screens.users.UsersScreen
import com.android.virginmoney.ui.screens.users.viewmodels.UsersViewModel

@ExperimentalComposeUiApi
@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.UsersScreen.route) {

        composable(route = Routes.UsersScreen.route) {
            val usersViewModel = hiltViewModel<UsersViewModel>()
            val uiState by usersViewModel.uiState.collectAsState()
            Box {
                UsersScreen(uiState = uiState)
            }
        }

        composable(route = Routes.RoomsScreen.route) {
            val roomsViewModel = hiltViewModel<RoomsViewModel>()
            val uiState by roomsViewModel.uiState.collectAsState()
            roomsViewModel.getRooms()

            Text(text = "Rooms")
        }
    }
}
