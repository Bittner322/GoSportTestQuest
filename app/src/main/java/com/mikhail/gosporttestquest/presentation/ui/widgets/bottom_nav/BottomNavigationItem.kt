package com.mikhail.gosporttestquest.presentation.ui.widgets.bottom_nav

import com.mikhail.gosporttestquest.R

data class BottomNavigationItem(
    val label: Int = 0,
    val icon: Int = 0,
    val route: String = ""
) {
    fun bottomNavigationItems() : List<BottomNavigationItem> {
        return listOf(
            BottomNavigationItem(
                label = R.string.bottom_nav_menu_title,
                icon = R.drawable.ic_menu,
                route = BottomNavScreens.Menu.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_cart_title,
                icon = R.drawable.ic_cart,
                route = BottomNavScreens.Cart.route
            ),
            BottomNavigationItem(
                label = R.string.bottom_nav_profile_title,
                icon = R.drawable.ic_profile,
                route = BottomNavScreens.Profile.route
            )
        )
    }
}