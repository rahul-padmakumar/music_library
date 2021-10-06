package com.example.musiclibrary.models

sealed class Resource<out T>(
    val data: T?, val errorCode: Int?, val errorMessage: String?, val status: Status) {

    companion object{
        const val DEFAULT_ERROR_CODE: Int = 100;
    }

    class Success<T>(data: T): Resource<T>(data, null, null, Status.SUCCESS)
    class Failure<Nothing>(errorCode: Int = DEFAULT_ERROR_CODE, errorMessage: String?):
            Resource<Nothing>(null, errorCode, errorMessage, Status.FAILURE)
    class Progress(): Resource<Nothing>(null, null, null, Status.PROGRESS)
}