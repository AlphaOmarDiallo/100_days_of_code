package com.alphaomardiallo.a100_days_of_code.feature.info.domain.remote

import com.alphaomardiallo.a100_days_of_code.feature.info.data.model.AppDto
import kotlinx.coroutines.flow.Flow

interface MyAppsService {
    suspend fun getApps(): Flow<List<AppDto>>
}
