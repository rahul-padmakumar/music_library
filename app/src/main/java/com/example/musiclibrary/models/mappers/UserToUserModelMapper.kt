package com.example.musiclibrary.models.mappers

import com.example.musiclibrary.datasource.db.entities.User
import com.example.musiclibrary.models.UserModel

class UserToUserModelMapper: Mapper<User, UserModel> {
    override fun to(data: User): UserModel {
        return UserModel(
            data.userName,
            data.password,
            data.id,
            data.address
        )
    }
}