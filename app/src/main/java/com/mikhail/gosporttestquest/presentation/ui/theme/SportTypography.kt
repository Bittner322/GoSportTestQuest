package com.mikhail.gosporttestquest.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class SportTypography(
    val cityTitle: TextStyle,
    val productTitle: TextStyle,
    val descriptionTitle: TextStyle,
    val inactiveTagTitle: TextStyle,
    val activeTagTitle: TextStyle,
    val price: TextStyle,
    val bottomNavItemStyle: TextStyle
)

@Composable
fun ProvideSportTypography(): SportTypography {
    return SportTypography(
        cityTitle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(500)
        ),
        productTitle = TextStyle(
            fontSize = 16.sp,
            fontWeight = FontWeight(700)
        ),
        descriptionTitle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight(400)
        ),
        inactiveTagTitle = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight(400)
        ),
        activeTagTitle = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight(600)
        ),
        price = TextStyle(
            fontSize = 13.sp,
            fontWeight = FontWeight(400)
        ),
        bottomNavItemStyle = TextStyle(
            fontSize = 12.sp,
            fontWeight = FontWeight(500)
        ),
    )
}

val LocalSportTypography = staticCompositionLocalOf<SportTypography> {
    error("LocalSportTypography not initialized")
}