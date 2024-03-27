package com.mikhail.gosporttestquest.data.network

import com.mikhail.gosporttestquest.data.network.models.Categories
import com.mikhail.gosporttestquest.data.network.models.Meals
import retrofit2.http.GET

interface NetworkService {

    @GET("v1/1/search.php?s")
    suspend fun getMeals(): Meals

    @GET("v1/1/categories.php")
    suspend fun getCategories(): Categories
}