package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.network.connectivity_check.ConnectivityObserver
import com.mikhail.gosporttestquest.data.network.connectivity_check.NetworkConnectivityObserver
import com.mikhail.gosporttestquest.data.repositories.CategoriesRepository
import com.mikhail.gosporttestquest.data.repositories.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuScreenViewModel @Inject constructor(
    private val mealRepository: MealRepository,
    private val categoriesRepository: CategoriesRepository,
    networkStatusTracker: NetworkConnectivityObserver
) : ViewModel() {
    val isDataLoaded = mutableStateOf(false)

    private val _uiState = MutableStateFlow(MenuScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    private val _mealsFlow = MutableStateFlow(emptyList<MealModel>())
    val mealsFlow = _mealsFlow.asStateFlow()

    private val _categoriesFlow = MutableStateFlow(emptyList<CategoryModel>())
    val categoriesFlow = _categoriesFlow.asStateFlow()

    val connectionState = networkStatusTracker.observe()

    init {
        viewModelScope.launch {
            connectionState
                .collect { status ->
                    when (status) {
                        ConnectivityObserver.Status.Available -> {
                            onScreenComposedOnline()
                        }
                        ConnectivityObserver.Status.Losing -> {
                            // ignore
                        }
                        ConnectivityObserver.Status.Lost -> {
                            onScreenComposedOffline()
                        }
                        ConnectivityObserver.Status.Unavailable -> {
                            onScreenComposedOffline()
                        }
                    }
                }
        }
    }

    fun onScreenComposedOnline() {
        viewModelScope.launch {
            categoriesRepository.loadAllCategoriesIntoDatabase()
            mealRepository.loadAllMealsIntoDatabase()
            getCategories()
        }
    }

    fun onScreenComposedOffline() {
        viewModelScope.launch {
            getCategories()
        }
    }

    private fun getSortedMeals(category: String) {
        mealRepository
            .getMealsFlow(category)
            .onEach {
                _mealsFlow.value = it
            }
            .launchIn(viewModelScope)
    }

    private fun getCategories() {
        categoriesRepository
            .getCategoryFlow()
            .onEach {
                _categoriesFlow.value = it
            }
            .map { categories ->
                if (categories.isNotEmpty()) {
                    getSortedMeals(categories.first().name)
                    isDataLoaded.value = true
                }
            }
            .launchIn(viewModelScope)
    }

    fun onActiveTagChange(tag: String) {
        _uiState.update {
            it.copy(activeTag = tag)
        }
        getSortedMeals(tag)
    }
}