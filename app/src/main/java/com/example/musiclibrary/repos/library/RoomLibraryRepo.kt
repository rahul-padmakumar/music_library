package com.example.musiclibrary.repos.library

import com.example.musiclibrary.datasource.db.DBManager
import com.example.musiclibrary.models.LibraryModel
import com.example.musiclibrary.models.UserLibraryModel
import com.example.musiclibrary.models.mappers.LibraryModelToLibraryMapper
import com.example.musiclibrary.models.mappers.UserAndLibraryToUserLibraryMapper

class RoomLibraryRepo(
    private val dbManager: DBManager,
    private val userAndLibraryToUserLibraryMapper: UserAndLibraryToUserLibraryMapper,
    private val libraryModelToLibraryMapper: LibraryModelToLibraryMapper
): LibraryRepo{

    override suspend fun createLibrary(userId: Int) {
        dbManager.createLibrary(
            libraryModelToLibraryMapper.to(LibraryModel(creatorId = userId))
        )
    }

    override suspend fun getLibraryInfo(userId: Int): UserLibraryModel {
        return userAndLibraryToUserLibraryMapper.to(dbManager.getLibraryDetails(userId))
    }

}