package com.mikhail.gosporttestquest.presentation.main_activity.nav_graphs

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mikhail.gosporttestquest.presentation.ui.screens.cart.CartScreen
import com.mikhail.gosporttestquest.presentation.ui.screens.menu.MenuScreen
import com.mikhail.gosporttestquest.presentation.ui.screens.profile.ProfileScreen
import com.mikhail.gosporttestquest.presentation.ui.widgets.bottom_nav.BottomNavScreens

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavScreens.Menu.route
    ) {
        composable(BottomNavScreens.Menu.route) {
            MenuScreen()
        }
        composable(BottomNavScreens.Profile.route) {
            ProfileScreen()
        }
        composable(BottomNavScreens.Cart.route) {
            CartScreen()
        }
    }
}