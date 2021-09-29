package com.example.musiclibrary.datasource.db.views

import androidx.room.ColumnInfo
import androidx.room.DatabaseView

@DatabaseView("SELECT user.user_name, library.id, library.user_id FROM user INNER JOIN library ON user.id = library.user_id")
data class LibraryUserDetail(
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "id") val libraryId: Int,
    @ColumnInfo(name = "user_id") val userId: Int
)
