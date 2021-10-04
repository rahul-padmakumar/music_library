package com.example.musiclibrary.di

import android.content.Context
import com.example.musiclibrary.MusicLibraryApplication
import dagger.BindsInstance
import dagger.Component

@Component()
interface AppComponent {
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }
}