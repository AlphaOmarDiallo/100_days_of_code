package com.alphaomardiallo.a100_days_of_code.feature.learn.domain.remote

import com.alphaomardiallo.a100_days_of_code.feature.learn.data.model.LearnDtoItem
import kotlinx.coroutines.flow.Flow

interface LearnService {
    suspend fun getLearn(): Flow<List<LearnDtoItem>>
}
