package com.mikhail.gosporttestquest.data.network

import com.mikhail.gosporttestquest.data.network.models.Meals
import retrofit2.http.GET
import retrofit2.http.Query

private const val DEFAULT_MEAL_CATEGORY = "Pizza"

interface NetworkService {

    @GET("v1/1/filter.php")
    suspend fun getMeals(
        @Query("c") category: String = DEFAULT_MEAL_CATEGORY
    ): Meals
}