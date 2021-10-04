package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])])
data class Library(
    @PrimaryKey(autoGenerate = true) @ColumnInfo(name = "id")val libraryId: Int,
    @ColumnInfo(name = "user_id") val userId: String
)
