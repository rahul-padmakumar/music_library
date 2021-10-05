package com.example.musiclibrary.di

import android.content.Context
import androidx.room.Room
import com.example.musiclibrary.datasource.db.MusicLibraryDatabase
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
}