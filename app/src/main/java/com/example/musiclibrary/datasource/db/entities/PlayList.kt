package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = Library::class, parentColumns = ["id"], childColumns = ["library_id"])])
data class PlayList(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "playlist_name") val playListName: String,
    @ColumnInfo(name = "library_id") val libraryId: Int
)
