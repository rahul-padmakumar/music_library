package com.example.musiclibrary.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.room.Room
import com.example.musiclibrary.datasource.db.MusicLibraryDatabase
import com.example.musiclibrary.datastore.dataStore
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Singleton
    @Provides
    fun musicLibraryDatabaseProvider(applicationContext: Context): MusicLibraryDatabase{
        return Room.databaseBuilder(
            applicationContext,
            MusicLibraryDatabase::class.java,
            "MusicLibraryDatabase"
        ).build()
    }

    @Singleton
    @Provides
    fun dataStoreProvider(applicationContext: Context): DataStore<Preferences>{
        return applicationContext.dataStore
    }
}