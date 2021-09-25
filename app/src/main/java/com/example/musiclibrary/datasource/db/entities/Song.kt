package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Song(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "song_name") val songName: String,
    @ColumnInfo(name = "song_path") val songYoutubeLink: String
)
