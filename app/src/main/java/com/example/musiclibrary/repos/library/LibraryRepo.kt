package com.example.musiclibrary.repos.library

import com.example.musiclibrary.models.UserLibraryModel

interface LibraryRepo {
    suspend fun createLibrary(userId: Int)
    suspend fun getLibraryInfo(userId: Int): UserLibraryModel
}