package com.arzhang.project.bookexplorer

import android.app.Application
import com.arzhang.project.bookexplorer.data.AppContainer
import com.arzhang.project.bookexplorer.data.DefaultAppContainer

class BookxApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}