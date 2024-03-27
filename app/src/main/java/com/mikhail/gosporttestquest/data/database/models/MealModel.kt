package com.mikhail.gosporttestquest.data.database.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "MealModel")
data class MealModel(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String,
    @ColumnInfo(name = "mealName")
    val mealName: String,
    @ColumnInfo(name = "mealPicture")
    val mealPicture: String,
    @ColumnInfo(name = "category")
    val category: String
)