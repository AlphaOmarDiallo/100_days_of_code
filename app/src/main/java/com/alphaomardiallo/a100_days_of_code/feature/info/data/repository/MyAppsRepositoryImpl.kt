package com.alphaomardiallo.a100_days_of_code.feature.info.data.repository

import com.alphaomardiallo.a100_days_of_code.feature.info.domain.model.App
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.remote.MyAppsService
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.repository.MyAppsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class MyAppsRepositoryImpl(private val service: MyAppsService) : MyAppsRepository {
    override suspend fun getApps(): Flow<List<App>> {
        return try {
            service.getApps().map { dtoList ->
                dtoList.map { it.toDomain() }
            }
        } catch (e: Exception){
            flow { emit(emptyList()) }
        }
    }
}
