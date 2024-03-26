package com.mikhail.gosporttestquest.di.module

import com.mikhail.gosporttestquest.data.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    @Singleton
    fun provideArticleDatabase(): AppDatabase = AppDatabase.INSTANCE
}