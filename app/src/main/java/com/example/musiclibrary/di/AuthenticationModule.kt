package com.example.musiclibrary.di

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.models.mappers.UserModelToUserMapper
import com.example.musiclibrary.models.mappers.UserToUserModelMapper
import com.example.musiclibrary.repos.authentication.AuthenticationRepo
import com.example.musiclibrary.repos.authentication.RoomAuthenticationRepo
import dagger.Module
import dagger.Provides

@Module
class AuthenticationModule {

    @Provides
    fun roomAuthenticationRepoProvider(
        dbManager: DBManager,
        userModelToUserMapper: UserModelToUserMapper,
        userToUserModelMapper: UserToUserModelMapper): AuthenticationRepo {

        return RoomAuthenticationRepo(dbManager, userModelToUserMapper, userToUserModelMapper)
    }

    @Provides
    fun userToUserModelMapperProvider(): UserToUserModelMapper{
        return UserToUserModelMapper()
    }

    @Provides
    fun userModelToUserMapper(): UserModelToUserMapper{
        return UserModelToUserMapper()
    }
}