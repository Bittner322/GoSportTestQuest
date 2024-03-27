package com.mikhail.gosporttestquest.presentation.ui.screens.menu

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.repositories.CategoriesRepository
import com.mikhail.gosporttestquest.data.repositories.MealRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MenuScreenViewModel @Inject constructor(
    private val mealRepository: MealRepository,
    private val categoriesRepository: CategoriesRepository
) : ViewModel() {
    var isDataLoaded = false

    private val _uiState = MutableStateFlow(MenuScreenUiState.default)
    val uiState = _uiState.asStateFlow()

    private val _mealsFlow = MutableStateFlow(emptyList<MealModel>())
    val mealsFlow = _mealsFlow.asStateFlow()

    private val _categoriesFlow = MutableStateFlow(emptyList<CategoryModel>())
    val categoriesFlow = _categoriesFlow.asStateFlow()

    init {
        loadAllCategories()
        loadAllMeals()
        getCategories()
        //getSortedMeals(_categoriesFlow.value.first().name)
        isDataLoaded = true
    }

    private fun getSortedMeals(category: String) {
        mealRepository
            .getMealsFlow(category)
            .onEach {
                Log.d("LOGTAG", "getSortedMeals: ${it}")

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
                getSortedMeals(categories.first().name)
            }
            .launchIn(viewModelScope)
    }

    private fun loadAllCategories() {
        viewModelScope.launch {
            categoriesRepository.loadAllCategoriesIntoDatabase()
        }
    }

    private fun loadAllMeals() {
        viewModelScope.launch {
            mealRepository.loadAllMealsIntoDatabase()
        }
    }
}