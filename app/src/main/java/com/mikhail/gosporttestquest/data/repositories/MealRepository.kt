package com.mikhail.gosporttestquest.data.repositories

import com.mikhail.gosporttestquest.data.database.AppDatabase
import com.mikhail.gosporttestquest.data.database.models.MealModel
import com.mikhail.gosporttestquest.data.network.NetworkService
import javax.inject.Inject

class MealRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {
    private suspend fun mapMeals(category: String): List<MealModel> {
        return networkService.getMeals(category = category).meals.map { meal ->
            MealModel(
                id = meal.idMeal,
                mealName = meal.strMeal,
                mealPicture = meal.strMealThumb
            )
        }
    }

    suspend fun loadAllMealsIntoDatabase(category: String): Result<Unit> {
        return runCatching {
            database.mealDao().insertAll(mapMeals(category))
        }
    }
}