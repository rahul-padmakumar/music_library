package com.example.musiclibrary.models

import com.example.musiclibrary.datasource.db.entities.Address

data class UserModel(
    val name: String,
    val password: String,
    val id: Int = 0,
    val address: Address
)