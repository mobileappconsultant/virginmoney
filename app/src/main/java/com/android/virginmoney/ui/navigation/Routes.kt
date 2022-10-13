package com.android.virginmoney.ui.navigation

sealed class Routes(val route: String) {
    object UsersScreen : Routes("usersScreen")
    object RoomsScreen : Routes("roomsScreen")
    object UserDetailsScreen : Routes("userDetailsScreen?user={user}") {
        fun createRoute(user: String) = "userDetailsScreen?user=$user"
    }
}
