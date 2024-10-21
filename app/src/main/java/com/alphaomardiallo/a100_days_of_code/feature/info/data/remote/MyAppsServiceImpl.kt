package com.alphaomardiallo.a100_days_of_code.feature.info.data.remote

import com.alphaomardiallo.a100_days_of_code.feature.info.data.model.AppDto
import com.alphaomardiallo.a100_days_of_code.feature.info.data.model.AppsDto
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.remote.MyAppsService
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class MyAppsServiceImpl(val httpClient: HttpClient) : MyAppsService {
    override suspend fun getApps(): Flow<List<AppDto>> = try {
        flow {
            val result = httpClient.get<AppsDto>(BASE_URL)
            emit(result.apps)
        }
    } catch (e: IOException) {
        flow { emit(emptyList()) }
    }

    private companion object {
        const val BASE_URL = "https://myapps-hppaqs61.b4a.run/app-list"
    }
}
