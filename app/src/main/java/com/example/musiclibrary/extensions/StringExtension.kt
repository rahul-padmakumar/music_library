package com.example.musiclibrary.extensions

fun String.isValidUserName(): Boolean{
    return this.trim().isNotEmpty()
}

fun String.isValidPassWord(): Boolean{
    return this.trim().length >= 6
}