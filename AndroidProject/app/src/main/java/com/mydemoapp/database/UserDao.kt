package com.mydemoapp.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM user WHERE name LIKE :email")
    fun findByTitle(email: String): UserEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg user: UserEntity)

    @Delete
    fun delete(user: UserEntity)

    @Update
    fun updateTodo(vararg user: UserEntity)
}