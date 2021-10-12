package com.example.musiclibrary.di

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.models.mappers.LibraryModelToLibraryMapper
import com.example.musiclibrary.models.mappers.UserAndLibraryToUserLibraryMapper
import com.example.musiclibrary.repos.library.LibraryRepo
import com.example.musiclibrary.repos.library.RoomLibraryRepo
import dagger.Module
import dagger.Provides

@Module
class LibraryModule {

    @Provides
    fun libraryRepositoryProvider(
        dbManager: DBManager,
        libraryModelToLibraryMapper: LibraryModelToLibraryMapper,
        userAndLibraryToUserLibraryMapper: UserAndLibraryToUserLibraryMapper
    ): LibraryRepo{
        return RoomLibraryRepo(
            dbManager,
            userAndLibraryToUserLibraryMapper, libraryModelToLibraryMapper)
    }

    @Provides
    fun libraryModelToLibraryMapperProvider(): LibraryModelToLibraryMapper{
        return LibraryModelToLibraryMapper()
    }

    @Provides
    fun userAndLibraryToUserLibraryMapperProvider(): UserAndLibraryToUserLibraryMapper{
        return UserAndLibraryToUserLibraryMapper()
    }
}