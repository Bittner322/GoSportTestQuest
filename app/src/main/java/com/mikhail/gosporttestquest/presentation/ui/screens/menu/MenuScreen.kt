package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.bottomNavHeight
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportTopBar
import com.mikhail.gosporttestquest.presentation.ui.widgets.custom_toolbar.SportToolbar

@Composable
fun MenuScreen(menuScreenViewModel: MenuScreenViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = SportTheme.color.white
            )
            .padding(bottom = bottomNavHeight)
            .systemBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SportToolbar(
            centralContent = {
                SportTopBar(city = stringResource(R.string.menu_city))
            }
        )
    }
}