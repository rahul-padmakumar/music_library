package com.example.musiclibrary.repos

import com.example.musiclibrary.models.UserModel

interface AuthenticationRepo {
    suspend fun insertUser(userModel: UserModel)
    suspend fun getUserInfo(userName: String, password: String): UserModel?
    suspend fun getUserInfo(id: Int): UserModel?
}