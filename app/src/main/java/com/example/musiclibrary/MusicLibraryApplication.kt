package com.example.musiclibrary

import android.app.Application
import com.example.musiclibrary.di.DaggerAppComponent

class MusicLibraryApplication: Application(){

    val appComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    override fun onCreate() {
        super.onCreate()
    }
}