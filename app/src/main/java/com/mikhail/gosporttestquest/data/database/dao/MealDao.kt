package com.mikhail.gosporttestquest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mikhail.gosporttestquest.data.database.models.MealModel
import kotlinx.coroutines.flow.Flow

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(mealModel: MealModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(mealModels: List<MealModel>)

    @Update
    suspend fun update(mealModel: MealModel)

    @Delete
    suspend fun delete(mealModel: MealModel)

    @Query("SELECT * FROM MealModel WHERE category = :category")
    fun getMealsData(category: String): Flow<List<MealModel>>
}