package com.mikhail.gosporttestquest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mikhail.gosporttestquest.data.database.dao.CategoryDao
import com.mikhail.gosporttestquest.data.database.dao.MealDao
import com.mikhail.gosporttestquest.data.database.models.CategoryModel
import com.mikhail.gosporttestquest.data.database.models.MealModel

@Database(
    entities = [MealModel::class, CategoryModel::class],
    version = 2,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun mealDao(): MealDao
    abstract fun categoryDao(): CategoryDao

    companion object {
        lateinit var INSTANCE: AppDatabase
            private set

        fun initDatabase(context: Context) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                "database"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}