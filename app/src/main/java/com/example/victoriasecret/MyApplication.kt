package com.example.victoriasecret

import android.app.Application
import com.example.victoriasecret.di.AppComponent
import com.example.victoriasecret.di.DaggerAppComponent

class MyApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder()
            .build()
    }
}