package com.example.button.to.action

import android.app.Application
import com.example.button.to.action.di.Modules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(Modules.main, Modules.data))
        }
    }
}