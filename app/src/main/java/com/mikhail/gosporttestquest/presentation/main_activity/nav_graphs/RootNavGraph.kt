package com.mikhail.gosporttestquest.presentation.main_activity.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhail.gosporttestquest.presentation.ui.widgets.bottom_nav.BottomNavScreens

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Menu.route
    ) {
        composable(BottomNavScreens.Menu.route) {

        }
        composable(BottomNavScreens.Profile.route) {

        }
        composable(BottomNavScreens.Cart.route) {

        }
    }
}