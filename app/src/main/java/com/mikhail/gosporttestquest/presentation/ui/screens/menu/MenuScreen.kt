package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import com.mikhail.gosporttestquest.R
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.presentation.ui.theme.SportTheme
import com.mikhail.gosporttestquest.presentation.ui.theme.bottomNavHeight
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportBanner
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportMealWidget
import com.mikhail.gosporttestquest.presentation.ui.widgets.SportTopBar
import com.mikhail.gosporttestquest.presentation.ui.widgets.sort_tag.SportSortTag
import kotlin.math.roundToInt

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MenuScreen(
    viewModel: MenuScreenViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    val categories by viewModel.categoriesFlow.collectAsState()
    val meals by viewModel.mealsFlow.collectAsState()
    val isDataLoaded by viewModel.isDataLoaded

    if (!isDataLoaded) {
        Box(
            modifier = Modifier
                .fillMaxSize()
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

@Composable
fun CollapsingToolbar(
    tags: List<CategoryModel>,
    meals: List<MealModel>,
    uiState: MenuScreenUiState,
    viewModel: MenuScreenViewModel,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current

    var headerSize by remember { mutableStateOf(IntSize(0, 0)) }
    val headerHeight by remember(headerSize) { mutableStateOf(with(density) { headerSize.height.toDp() }) }

    var tabsSize by remember { mutableStateOf(IntSize(0, 0)) }
    val tabsHeight by remember(tabsSize) { mutableStateOf(with(density) { tabsSize.height.toDp() }) }

    var appbarSize by remember { mutableStateOf(IntSize(0, 0)) }

    val headerOffsetHeightPx = remember { mutableFloatStateOf(0f) }
    val nestedScrollConnection = remember(headerSize) {
        object : NestedScrollConnection {
            val headerHeightPx = headerSize.height.toFloat()

            override fun onPreScroll(available: Offset, source: NestedScrollSource): Offset {
                val delta = available.y
                val newOffset = headerOffsetHeightPx.floatValue + delta
                headerOffsetHeightPx.floatValue = newOffset.coerceIn(-headerHeightPx, 0f)
                return Offset.Zero
            }
        }
    }
    Column(
        modifier = modifier
    ) {
        SportTopBar(
            modifier = Modifier
                .zIndex(2f)
                .onSizeChanged { appbarSize = it },
            city = stringResource(R.string.menu_city)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .nestedScroll(nestedScrollConnection)
        ) {
            Column(
                modifier = Modifier
                    .offset { IntOffset(x = 0, y = headerOffsetHeightPx.floatValue.roundToInt()) }
                    .background(color = SportTheme.color.white)
                    .zIndex(1f),
            ) {
                SportBanner(modifier = Modifier.onSizeChanged { headerSize = it })
                LazyRow(
                    modifier = Modifier
                        .padding(vertical = 16.dp)
                        .onSizeChanged { tabsSize = it },
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
            LazyColumn(
                contentPadding = PaddingValues(
                    top = headerHeight + tabsHeight,
                    bottom = bottomNavHeight
                )
            ) {
                items(meals) { meal ->
                    SportMealWidget(meal = meal)
                }
            }
        }
    }
}