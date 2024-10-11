package com.alphaomardiallo.a100_days_of_code.common.domain.repository

import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun upsertUser(user: User): Long

    suspend fun deleteUser(user: User)

    suspend fun getUserById(id: Long): Flow<User?>
}
