package com.example.musiclibrary.di

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.repos.AuthenticationRepo
import com.example.musiclibrary.repos.RoomAuthenticationRepo
import dagger.Module
import dagger.Provides

@Module
class AuthenticationModule {

    @Provides
    fun roomAuthenticationRepoProvider(dbManager: DBManager): AuthenticationRepo{
        return RoomAuthenticationRepo(dbManager)
    }
}