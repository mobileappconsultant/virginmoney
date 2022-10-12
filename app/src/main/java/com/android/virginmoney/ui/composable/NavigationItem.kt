package com.android.virginmoney.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Group
import androidx.compose.material.icons.filled.MeetingRoom
import androidx.compose.ui.graphics.vector.ImageVector
import com.android.virginmoney.ui.navigation.Routes

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Users : NavigationItem(Routes.UsersScreen.route, Icons.Filled.Group, "Users")
    object Rooms : NavigationItem(Routes.RoomsScreen.route, Icons.Filled.MeetingRoom, "Rooms")
}
