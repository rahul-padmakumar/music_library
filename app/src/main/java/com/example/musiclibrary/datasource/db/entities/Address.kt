package com.example.musiclibrary.datasource.db.entities

import androidx.room.ColumnInfo

data class Address(
    @ColumnInfo(name = "street_name") val streetName: String,
    @ColumnInfo(name = "house_name") val houseName: String,
    @ColumnInfo(name = "city") val city: String,
    @ColumnInfo(name = "state") val state: String,
    @ColumnInfo(name = "country") val country: String
)
