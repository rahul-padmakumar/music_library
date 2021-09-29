package com.example.musiclibrary.datasource.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.musiclibrary.datasource.db.entities.*
import com.example.musiclibrary.datasource.db.views.LibraryUserDetail

@Database(entities = [Library::class, PlayList::class, PlayListSongsCrossRef::class, Song::class, User::class],
views = [LibraryUserDetail::class],
version = 1)
abstract class MusicLibraryDatabase: RoomDatabase(){
    companion object{
        @Synchronized
        fun getInstance(applicationContext: Context): MusicLibraryDatabase{
            return Room.databaseBuilder(
                applicationContext,
                MusicLibraryDatabase::class.java,
                "MusicLibraryDatabase"
            ).build()
        }
    }
}