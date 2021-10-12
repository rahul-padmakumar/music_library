package com.example.musiclibrary.repos.authentication

import com.example.musiclibrary.models.UserModel

interface AuthenticationRepo {
    suspend fun insertUser(userModel: UserModel): Long
    suspend fun getUserInfo(userName: String, password: String): UserModel?
    suspend fun getUserInfo(id: Int): UserModel?
}