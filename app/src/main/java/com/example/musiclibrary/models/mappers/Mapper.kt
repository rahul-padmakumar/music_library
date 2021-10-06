package com.example.musiclibrary.models.mappers

interface Mapper<S, D> {
    fun to(data: S): D
}