package com.mikhail.gosporttestquest.presentation.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

data class SportColors(
    val white: Color,
    val grey: Color,
    val lightGrey: Color,
    val pink: Color,
    val lightPink: Color,
    val bottomNavBackground: Color,
    val black: Color
)

fun ProvideSportColors(): SportColors {
    return SportColors(
        white = Color(0xFFFFFFFF),
        grey = Color(0xFF7B7B7B),
        lightGrey = Color(0xFFAAAAAD),
        pink = Color(0xFFFD3A69),
        lightPink = Color(0xFFFD3A69).copy(alpha = 0.2f),
        bottomNavBackground = Color(0xFFF0F0F0),
        black = Color(0xFF000000),
    )
}

val LocalSportColors = staticCompositionLocalOf<SportColors> {
    error { "LocalSportColors not provided" }
}