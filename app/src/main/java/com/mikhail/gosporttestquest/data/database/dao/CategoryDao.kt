package com.mikhail.gosporttestquest.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun add(categoryModel: CategoryModel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(categoryModels: List<CategoryModel>)

    @Update
    suspend fun update(categoryModel: CategoryModel)

    @Delete
    suspend fun delete(categoryModel: CategoryModel)

    @Query("SELECT * FROM CategoryModel")
    fun getCategoryData(): Flow<List<CategoryModel>>

    @Query("SELECT * FROM CategoryModel LIMIT 1")
    fun getFirstCategory(): CategoryModel
}