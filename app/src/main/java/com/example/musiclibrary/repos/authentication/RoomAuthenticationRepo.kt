package com.example.musiclibrary.repos.authentication

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.models.UserModel
import com.example.musiclibrary.models.mappers.UserModelToUserMapper
import com.example.musiclibrary.models.mappers.UserToUserModelMapper

class RoomAuthenticationRepo(
    private val dbManager: DBManager,
    private val userModelToUserMapper: UserModelToUserMapper,
    private val userToUserModelMapper: UserToUserModelMapper
): AuthenticationRepo {

    override suspend fun insertUser(userModel: UserModel): Long {
        return dbManager.insertUser(userModelToUserMapper.to(userModel))
    }

    override suspend fun getUserInfo(userName: String, password: String): UserModel? {
        val user = dbManager.getUser(userName, password)
        return if(user != null) userToUserModelMapper.to(user) else null
    }

    override suspend fun getUserInfo(id: Int): UserModel? {
        val user = dbManager.getUser(id)
        return if(user != null) userToUserModelMapper.to(user) else null
    }
}