package com.example.musiclibrary.repos

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.datasource.db.entities.User

class RoomAuthenticationRepo(val dbManager: DBManager): AuthenticationRepo {
    override suspend fun insertUser(user: User) {
        dbManager.insertUser(user)
    }

    override suspend fun getUserInfo(userName: String, password: String): User {
        return dbManager.getUser(userName, password)
    }

    override suspend fun getUserInfo(id: Int): User {
        return dbManager.getUser(id)
    }
}