package com.mikhail.gosporttestquest.presentation.ui.theme.defaults

import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme

object SportBottomNavDefaults {

    @Composable
    fun bottomNavItemColors(
        indicatorColor: Color = SportTheme.color.bottomNavBackground,
        selectedColor: Color = SportTheme.color.pink,
        unselectedColor: Color = SportTheme.color.grey
    ): NavigationBarItemColors {
        return NavigationBarItemDefaults.colors(
            selectedIconColor = selectedColor,
            unselectedIconColor = unselectedColor,
            selectedTextColor = selectedColor,
            unselectedTextColor = unselectedColor,
            indicatorColor = indicatorColor
        )
    }
}