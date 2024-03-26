package com.mikhail.gosporttestquest.presentation.ui.theme.defaults

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme

object SportTopBarDefaults {

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun topBarColors(
        containerColor: Color = SportTheme.color.white
    ): TopAppBarColors {
        return TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor
        )
    }
}