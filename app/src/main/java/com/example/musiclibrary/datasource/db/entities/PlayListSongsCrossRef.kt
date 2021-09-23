package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity

@Entity(primaryKeys = ["song_id", "playlist_id"])
data class PlayListSongsCrossRef (
    @ColumnInfo(name = "song_id") val songId: Int,
    @ColumnInfo(name = "playlist_id") val playList: Int
)