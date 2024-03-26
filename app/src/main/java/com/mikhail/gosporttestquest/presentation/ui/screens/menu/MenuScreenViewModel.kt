package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.repositories.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MenuScreenViewModel @Inject constructor(
    private val mealRepository: MealRepository
): ViewModel() {
    private var isDataLoaded = false

    private val _uiState = MutableStateFlow(MenuScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    private val _mealsFlow = MutableStateFlow(emptyList<MealModel>())
    val mealsFlow = _mealsFlow.asStateFlow()

    init {
        /*viewModelScope.launch {
            mealRepository.loadAllMealsIntoDatabase(_uiState.value.activeTag.name.lowercase())
            isDataLoaded = true
        }*/
    }

    private fun getSortedMeals(category: String) {
        mealRepository.getMealsFlow(category)
            .onEach { _mealsFlow.value = it }
            .launchIn(viewModelScope)
    }
}