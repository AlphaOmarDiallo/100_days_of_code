package com.alphaomardiallo.a100_days_of_code.common.domain.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.UserEntity

interface UserRepository {
    suspend fun upsertUser(user: UserEntity): Long

    suspend fun deleteUser(user: UserEntity)

    suspend fun getUserById(id: Long): UserEntity?
}
