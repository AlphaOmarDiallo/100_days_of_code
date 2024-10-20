package com.alphaomardiallo.a100_days_of_code.feature.info.domain.repository

import com.alphaomardiallo.a100_days_of_code.feature.info.domain.model.App
import kotlinx.coroutines.flow.Flow

interface MyAppsRepository {
    suspend fun getApps(): Flow<List<App>>
}
