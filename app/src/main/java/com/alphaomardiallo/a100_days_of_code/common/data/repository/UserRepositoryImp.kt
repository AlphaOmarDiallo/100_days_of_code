package com.alphaomardiallo.a100_days_of_code.common.data.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.UserDao
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository

class UserRepositoryImp(private val userDao: UserDao) : UserRepository {
    override suspend fun upsertUser(user: User): Long {
        return userDao.upsertUser(user.toEntity())
    }

    override suspend fun deleteUser(user: User) {
        userDao.deleteUser(user.toEntity())
    }

    override suspend fun getUserById(id: Long): User? {
        return userDao.getUserById(id)?.toDomain()
    }
}
