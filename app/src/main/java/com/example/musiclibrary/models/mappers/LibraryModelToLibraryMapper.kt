package com.example.musiclibrary.models.mappers

import com.example.musiclibrary.datasource.db.entities.Library
import com.example.musiclibrary.models.LibraryModel

class LibraryModelToLibraryMapper: Mapper<LibraryModel, Library> {
    override fun to(data: LibraryModel): Library {
        return Library(
            data.id,
            data.creatorId
        )
    }
}