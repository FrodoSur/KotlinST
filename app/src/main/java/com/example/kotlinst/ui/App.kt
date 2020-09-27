package com.example.kotlinst.ui

import android.app.Application
import com.example.kotlinst.di.appModule
import com.example.kotlinst.di.mainModule
import com.example.kotlinst.di.noteModule
import com.example.kotlinst.di.splashModule
import org.koin.android.ext.android.startKoin
class App: Application() {

    companion object {
        lateinit var instance : App
            private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin(this, listOf(appModule, splashModule, mainModule, noteModule))
    }
}