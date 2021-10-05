package com.example.musiclibrary.datasource.db.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.musiclibrary.datasource.db.entities.User

@Dao
interface UserDao {

    @Insert
    suspend fun addUser(user: User)

    @Query("SELECT * FROM user WHERE id = :id")
    suspend fun getUser(id: Int): User

    @Query("SELECT * FROM user WHERE user_name LIKE :userName AND password LIKE :password")
    suspend fun getUser(userName:String, password: String): User
}