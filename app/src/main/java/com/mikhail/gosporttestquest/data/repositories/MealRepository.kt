package com.mikhail.gosporttestquest.data.repositories

import com.mikhail.gosporttestquest.data.database.AppDatabase
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class MealRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {
    private suspend fun loadMealsFromNetwork(category: String): List<MealModel> {
        return networkService.getMeals(category = category).meals.map { meal ->
            MealModel(
                id = meal.idMeal,
                mealName = meal.strMeal,
                mealPicture = meal.strMealThumb,
                category = category
            )
        }
    }

    suspend fun loadAllMealsIntoDatabase(category: String) {
        database.mealDao().insertAll(loadMealsFromNetwork(category))
    }

    fun getMealsFlow(
        category: String
    ): Flow<List<MealModel>> {
        return database.mealDao().getMealsData(category)
            .flowOn(Dispatchers.IO)
    }
}