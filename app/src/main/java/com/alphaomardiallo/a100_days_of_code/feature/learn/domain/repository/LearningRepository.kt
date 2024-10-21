package com.alphaomardiallo.a100_days_of_code.feature.learn.domain.repository

import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.model.LearnItem
import kotlinx.coroutines.flow.Flow

interface LearningRepository {
    suspend fun getLearning(): Flow<List<LearnItem>>
}
