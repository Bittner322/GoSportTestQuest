package com.mikhail.gosporttestquest.data.repositories

import com.mikhail.gosporttestquest.data.database.AppDatabase
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.network.NetworkService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class CategoriesRepository @Inject constructor(
    private val networkService: NetworkService,
    private val database: AppDatabase
) {
    private suspend fun loadCategoriesFromNetwork(): List<CategoryModel> {
        return networkService.getCategories().categories.map { category ->
            CategoryModel(
                id = category.idCategory,
                name = category.strCategory,
                description = category.strCategoryDescription,
                picture = category.strCategoryThumb
            )
        }
    }

    suspend fun loadAllCategoriesIntoDatabase() {
        database.categoryDao().insertAll(loadCategoriesFromNetwork())
    }

    fun getCategoryFlow(): Flow<List<CategoryModel>> {
        return database.categoryDao().getCategoryData()
            .flowOn(Dispatchers.IO)
    }
}