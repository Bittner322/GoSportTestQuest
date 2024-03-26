package com.mikhail.gosporttestquest.presentation.ui.widgets.bottom_nav

sealed class BottomNavScreens(val route: String) {
    data object Menu: BottomNavScreens(route = BottomNavRoutes.MenuScreenRoute)
    data object Cart: BottomNavScreens(route = BottomNavRoutes.CartScreenRoute)
    data object Profile: BottomNavScreens(route = BottomNavRoutes.ProfileScreenRoute)
}