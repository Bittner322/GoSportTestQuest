package com.mikhail.gosporttestquest

import android.app.Application
import com.mikhail.gosporttestquest.data.database.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {

    companion object {
        private lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppDatabase.initDatabase(context = this)
    }
}