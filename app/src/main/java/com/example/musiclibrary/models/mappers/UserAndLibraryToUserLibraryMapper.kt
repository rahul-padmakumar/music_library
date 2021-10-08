package com.example.musiclibrary.models.mappers

import com.example.musiclibrary.datasource.db.entities.Library
import com.example.musiclibrary.datasource.db.relations.UserAndLibrary
import com.example.musiclibrary.models.LibraryModel
import com.example.musiclibrary.models.UserLibraryModel

class UserAndLibraryToUserLibraryMapper: Mapper<UserAndLibrary, UserLibraryModel> {
    override fun to(data: UserAndLibrary): UserLibraryModel {
        return UserLibraryModel(
            data.library.libraryId,
            data.user.userName,
            data.user.id
        )
    }
}