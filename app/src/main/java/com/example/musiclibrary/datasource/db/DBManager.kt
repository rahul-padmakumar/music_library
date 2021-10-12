package com.example.musiclibrary.datasource.db

import com.example.musiclibrary.MusicLibraryApplication
import com.example.musiclibrary.datasource.db.entities.Library
import com.example.musiclibrary.datasource.db.entities.User
import com.example.musiclibrary.datasource.db.relations.UserAndLibrary
import com.example.musiclibrary.di.AppComponent
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DBManager @Inject constructor(val musicLibraryDatabase: MusicLibraryDatabase){

    suspend fun insertUser(user: User): Long{
        return musicLibraryDatabase.userDao().addUser(user)
    }

    suspend fun getUser(userName: String, password: String): User?{
        return musicLibraryDatabase.userDao().getUser(userName, password)
    }

    suspend fun getUser(id: Int): User?{
        return musicLibraryDatabase.userDao().getUser(id)
    }

    suspend fun createLibrary(library: Library){
        musicLibraryDatabase.libraryDao().addLibrary(library)
    }

    suspend fun getLibraryDetails(userId: Int): UserAndLibrary{
        return musicLibraryDatabase.libraryDao().getLibraryOfUser(userId)[0]
    }
}