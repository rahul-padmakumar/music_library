package com.example.musiclibrary.models.mappers

import com.example.musiclibrary.datasource.db.entities.User
import com.example.musiclibrary.models.UserModel

class UserModelToUserMapper: Mapper<UserModel, User> {
    override fun to(data: UserModel): User {
        return User(
            data.id,
            data.name,
            data.password,
            data.address
        )
    }
}