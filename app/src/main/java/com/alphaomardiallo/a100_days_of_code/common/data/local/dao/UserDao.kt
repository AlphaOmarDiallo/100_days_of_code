package com.alphaomardiallo.a100_days_of_code.common.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Upsert
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.UserEntity

@Dao
interface UserDao {

    @Upsert
    suspend fun upsertUser(user: UserEntity): Long

    @Delete
    suspend fun deleteUser(user: UserEntity)
}
