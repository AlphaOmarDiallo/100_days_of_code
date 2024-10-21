package com.alphaomardiallo.a100_days_of_code.feature.learn.data.repository

import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.model.LearnItem
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.remote.LearnService
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.repository.LearningRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class LearningRepositoryImpl(private val service: LearnService) : LearningRepository {
    override suspend fun getLearning(): Flow<List<LearnItem>> {
        return try {
            service.getLearn().map { list ->
                list.map { it.toDomain() }
            }
        } catch (e: Exception){
            flow { emit(emptyList()) }
        }
    }
}
