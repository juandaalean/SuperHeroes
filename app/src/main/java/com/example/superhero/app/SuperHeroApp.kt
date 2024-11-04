package com.example.superhero.app

import android.app.Application
import com.example.superhero.app.di.AppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class SuperHeroApp: Application()  {


    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@SuperHeroApp)
            //modules(AppModule().module)
        }
    }
}