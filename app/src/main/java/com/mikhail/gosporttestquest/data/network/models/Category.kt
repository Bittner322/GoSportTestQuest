package com.mikhail.gosporttestquest.data.network.models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Categories(
    @SerialName("categories")
    val categories: List<Category>
) {
    @Serializable
    data class Category(
        @SerialName("idCategory")
        val idCategory: String,
        @SerialName("strCategory")
        val strCategory: String,
        @SerialName("strCategoryDescription")
        val strCategoryDescription: String,
        @SerialName("strCategoryThumb")
        val strCategoryThumb: String
    )
}