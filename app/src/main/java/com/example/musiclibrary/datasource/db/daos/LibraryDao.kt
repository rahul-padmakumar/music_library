package com.example.musiclibrary.datasource.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.musiclibrary.datasource.db.entities.Library
import com.example.musiclibrary.datasource.db.relations.UserAndLibrary

@Dao
interface LibraryDao {
    @Insert
    fun addLibrary(library: Library)

    @Query("SELECT * FROM USER WHERE id = :userId")
    fun getLibraryOfUser(userId: Int): List<UserAndLibrary>
}