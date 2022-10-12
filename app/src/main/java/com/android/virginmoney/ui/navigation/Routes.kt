package com.android.virginmoney.ui.navigation

sealed class Routes(val route: String) {
    object MainScreen : Routes("mainScreen")
    object DetailsScreen : Routes("detailsScreen")
}
