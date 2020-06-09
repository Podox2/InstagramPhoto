package com.example.podo.instagramphoto

import android.app.Application
import com.example.podo.instagramphoto.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(listOf(viewModelModule))
        }
    }

}