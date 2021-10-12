package com.example.musiclibrary.datasource.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.musiclibrary.datasource.db.entities.Library
import com.example.musiclibrary.datasource.db.entities.User

data class UserAndLibrary(
    @Embedded val user: User,
    @Relation(parentColumn = "id", entityColumn = "user_id")
    val library: Library
)
