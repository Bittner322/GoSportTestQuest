package com.mikhail.gosporttestquest.presentation.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.unit.dp

@Composable
fun SportTheme(
    content: @Composable () -> Unit
) {
    val sportColors = ProvideSportColors()
    val sportTypography = ProvideSportTypography()

    MaterialTheme {
        CompositionLocalProvider(
            LocalSportColors provides sportColors,
            LocalSportTypography provides sportTypography,
            content = content
        )
    }
}

object SportTheme {
    val color: SportColors
        @Composable
        get() = LocalSportColors.current
    val typography: SportTypography
        @Composable
        get() = LocalSportTypography.current
}

val bottomNavHeight = 80.dp