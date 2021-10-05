package com.example.musiclibrary.repos

import com.example.musiclibrary.datasource.db.entities.User

interface AuthenticationRepo {
    suspend fun insertUser(user: User)
    suspend fun getUserInfo(userName: String, password: String): User
    suspend fun getUserInfo(id: Int): User
}