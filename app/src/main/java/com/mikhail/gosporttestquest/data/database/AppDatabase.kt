package com.mikhail.gosporttestquest.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mikhail.gosporttestquest.data.database.dao.MealDao
import com.mikhail.gosporttestquest.data.database.models.MealModel

@Database(
    entities = [MealModel::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase: RoomDatabase() {
    abstract fun mealDao(): MealDao

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