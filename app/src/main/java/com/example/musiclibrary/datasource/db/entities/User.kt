package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "password") val password: String,
    @Embedded(prefix = "user") val address: Address
)
