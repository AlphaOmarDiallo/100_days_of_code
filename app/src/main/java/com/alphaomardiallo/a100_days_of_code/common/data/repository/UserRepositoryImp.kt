package com.alphaomardiallo.a100_days_of_code.common.data.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.UserDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.UserEntity
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository

class UserRepositoryImp(private val userDao: UserDao) : UserRepository {
    override suspend fun upsertUser(user: UserEntity): Long {
        return userDao.upsertUser(user)
    }

    override suspend fun deleteUser(user: UserEntity) {
        userDao.deleteUser(user)
    }

    override suspend fun getUserById(id: Long): UserEntity? {
        return userDao.getUserById(id)
    }
}
