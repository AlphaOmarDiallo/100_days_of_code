package com.alphaomardiallo.a100_days_of_code.feature.learn.data.remote

import com.alphaomardiallo.a100_days_of_code.feature.learn.data.model.LearnDtoItem
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.remote.LearnService
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException

class LearnServiceImpl(val httpClient: HttpClient) : LearnService {
    override suspend fun getLearn(): Flow<List<LearnDtoItem>> = try {
        flow {
            val result = httpClient.get<List<LearnDtoItem>>(BASE_URL)
            emit(result)
        }
    } catch (e: IOException) {
        flow { emit(emptyList()) }
    }

    private companion object {
        const val BASE_URL = "https://myapps-hppaqs61.b4a.run/learning_resources"
    }
}
