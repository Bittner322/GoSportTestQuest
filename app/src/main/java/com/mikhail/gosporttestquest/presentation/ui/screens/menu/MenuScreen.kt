package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.network.connectivity_check.ConnectivityObserver
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.bottomNavHeight
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportBanner
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportMealWidget
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportTopBar
import com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag.SportSortTag

private const val BannersCount = 2

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuScreen(
    viewModel: MenuScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val categories by viewModel.categoriesFlow.collectAsState()
    val meals by viewModel.mealsFlow.collectAsState()
    val connection by viewModel.connectionState.collectAsState(
        initial = ConnectivityObserver.Status.Unavailable
    )
    val isDataLoaded by viewModel.isDataLoaded

    LaunchedEffect(Unit) {
        when (connection) {
            ConnectivityObserver.Status.Available -> {
                viewModel.onScreenComposedOnline()
            }
            ConnectivityObserver.Status.Losing -> {
                // ignore
            }
            ConnectivityObserver.Status.Lost -> {
                viewModel.onScreenComposedOffline()
            }
            ConnectivityObserver.Status.Unavailable -> {
                viewModel.onScreenComposedOffline()
            }
        }
    }

    if (!isDataLoaded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = SportTheme.color.white)
        ) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    } else {
        CollapsingToolbar(
            tags = categories,
            meals = meals,
            uiState = uiState,
            viewModel = viewModel
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CollapsingToolbar(
    tags: List<CategoryModel>,
    meals: List<MealModel>,
    uiState: MenuScreenUiState,
    viewModel: MenuScreenViewModel,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    val lazyColumnHeight = remember {
        mutableStateOf(0.dp)
    }
    val itemHeight = remember {
        mutableStateOf(0.dp)
    }
    val bannerHeight = remember {
        mutableStateOf(0.dp)
    }
    Column(
        modifier = modifier
    ) {
        SportTopBar(
            city = stringResource(R.string.menu_city)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .onSizeChanged { size ->
                        lazyColumnHeight.value = with(density) {
                            size.height.toDp()
                        }
                    },
                contentPadding = PaddingValues(
                    bottom = bottomNavHeight + (lazyColumnHeight.value - itemHeight.value *
                            meals.size - bannerHeight.value).coerceAtLeast(0.dp)
                )
            ) {
                item {
                    LazyRow {
                        items(BannersCount) {
                            SportBanner(
                                modifier = Modifier.onSizeChanged { size ->
                                    bannerHeight.value = with(density) {
                                        size.height.toDp()
                                    }
                                }
                            )
                        }
                    }
                }
                stickyHeader {
                    LazyRow(
                        modifier = Modifier
                            .background(color = SportTheme.color.white)
                            .padding(vertical = 16.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp),
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(tags) { category ->
                            SportSortTag(
                                category = category,
                                onClick = { viewModel.onActiveTagChange(tag = category.name) },
                                isActive = uiState.activeTag == category.name
                            )
                        }
                    }
                }
                items(meals) { meal ->
                    SportMealWidget(
                        modifier = Modifier.onSizeChanged { size ->
                            itemHeight.value = with(density) { size.height.toDp() }
                        },
                        meal = meal
                    )
                }
            }
        }
    }
}