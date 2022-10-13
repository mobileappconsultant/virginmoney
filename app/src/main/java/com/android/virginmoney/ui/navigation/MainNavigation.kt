package com.android.virginmoney.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.android.people.domain.model.User
import com.android.virginmoney.ui.screens.rooms.RoomsScreen
import com.android.virginmoney.ui.screens.rooms.viewmodels.RoomsViewModel
import com.android.virginmoney.ui.screens.users.UsersScreen
import com.android.virginmoney.ui.screens.users.details.UserDetailsScreen
import com.android.virginmoney.ui.screens.users.viewmodels.UsersViewModel
import com.google.gson.Gson

@ExperimentalCoilApi
@ExperimentalComposeUiApi
@Composable
fun MainNavigation(navController: NavHostController) {
    val gson: Gson = remember { Gson() }
    NavHost(navController, startDestination = Routes.UsersScreen.route) {

        composable(route = Routes.UsersScreen.route) {
            val usersViewModel = hiltViewModel<UsersViewModel>()
            val uiState by usersViewModel.uiState.collectAsState()
            UsersScreen(
                uiState = uiState,
                {
                    usersViewModel.getUsers()
                }
            ) {
                navController.navigate(
                    Routes.UserDetailsScreen.createRoute(gson.toJson(it))
                )
            }
        }

        composable(route = Routes.RoomsScreen.route) {
            val roomsViewModel = hiltViewModel<RoomsViewModel>()
            val uiState by roomsViewModel.uiState.collectAsState()
            RoomsScreen(roomUiState = uiState) {
                roomsViewModel.getRooms()
            }
        }

        composable(
            route = Routes.UserDetailsScreen.route,
            arguments = listOf(
                navArgument("user") {
                    type = NavType.StringType
                }
            )
        ) {
            it.arguments?.getString("user")?.let { user ->
                UserDetailsScreen(gson.fromJson(user, User::class.java))
            }
        }
    }
}
