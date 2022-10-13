package com.android.virginmoney.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.android.virginmoney.ui.composable.BottomNavigationBar
import com.android.virginmoney.ui.composable.NavigationItem
import com.android.virginmoney.ui.navigation.MainNavigation
import com.android.virginmoney.ui.navigation.Routes

@OptIn(ExperimentalCoilApi::class, ExperimentalComposeUiApi::class)
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val navRoutes = listOf(
        Routes.UsersScreen,
        Routes.RoomsScreen
    ).map {
        it.route
    }

    val navItems = listOf(
        NavigationItem.Users,
        NavigationItem.Rooms
    )

    Scaffold(
        topBar = {
            TopAppBar(modifier = Modifier.fillMaxWidth()) {
                if (navItems.firstOrNull { it.route == currentRoute } == null) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                    Spacer(modifier = Modifier.width(12.dp))
                }
                Text(
                    text = navItems.firstOrNull {
                        it.route == currentRoute
                    }?.title.orEmpty(),
                    style = MaterialTheme.typography.body1,
                    modifier = Modifier.padding(horizontal = 24.dp)
                )
            }
        },
        bottomBar =
        { if (currentRoute in navRoutes) BottomNavigationBar(navController) }
    ) {
        Box(modifier = Modifier.padding(it)) {
            MainNavigation(navController = navController)
        }
    }
}
