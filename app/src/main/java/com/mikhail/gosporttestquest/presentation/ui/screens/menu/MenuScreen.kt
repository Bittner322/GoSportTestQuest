package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.bottomNavHeight
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportMealWidget
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportTopBar
import com.mikhail.gosporttestquest.presentation.ui.widgets.custom_toolbar.SportToolbar
import com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag.SportSortTag

@Composable
fun MenuScreen(
    viewModel: MenuScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

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
        /*Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }*/

        SportToolbar(
            centralContent = {
                SportTopBar(city = stringResource(R.string.menu_city))
            },
            additionalContent = {
                LazyRow(
                    modifier = Modifier.padding(top = 16.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(Tag.entries.toTypedArray()) { tag ->
                        SportSortTag(
                            tag = tag,
                            onClick = { /*TODO*/ },
                            isActive = uiState.activeTag == tag
                        )
                    }
                }
            }
        )

        val meals by viewModel.mealsFlow.collectAsState()
        LazyColumn {
            items(meals) {meal ->
                SportMealWidget(meal = meal)
            }
        }
    }
}