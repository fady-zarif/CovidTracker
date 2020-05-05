package com.fadyz.CovidTracker

import android.app.Application
import com.fadyz.CovidTracker.KoinDi.AppModule

import com.fadyz.CovidTracker.adapters.adapterModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ApplicationClass : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@ApplicationClass)
            modules(listOf(AppModule, adapterModule))
        }
    }
}