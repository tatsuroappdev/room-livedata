package com.tatsuro.app.roomandlivedata

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun loadAll(): LiveData<List<User>>

    @Insert
    suspend fun insert(user: User)
}
