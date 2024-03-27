package com.mikhail.gosporttestquest.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meals(
    @SerialName("meals")
    val meals: List<Meal>
) {
    @Serializable
    data class Meal(
        @SerialName("dateModified")
        val dateModified: String? = null,
        @SerialName("idMeal")
        val idMeal: String,
        @SerialName("strArea")
        val strArea: String,
        @SerialName("strCategory")
        val strCategory: String,
        @SerialName("strMeal")
        val strMeal: String,
        @SerialName("strMealThumb")
        val strMealThumb: String
    )
}