package com.alphaomardiallo.a100_days_of_code.feature.learn.di

import com.alphaomardiallo.a100_days_of_code.feature.learn.data.remote.LearnServiceImpl
import com.alphaomardiallo.a100_days_of_code.feature.learn.data.repository.LearningRepositoryImpl
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.remote.LearnService
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.repository.LearningRepository
import com.alphaomardiallo.a100_days_of_code.feature.learn.presentation.LearningViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.features.DefaultRequest
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.features.logging.Logger
import io.ktor.client.features.logging.Logging
import io.ktor.client.features.observer.ResponseObserver
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import kotlinx.serialization.json.Json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import timber.log.Timber

private const val TIME_OUT = 10000

val learnModule = module {

    single<LearningRepository> { LearningRepositoryImpl(service = get()) }

    viewModel { LearningViewModel(learningRepository = get()) }

    factory<LearnService> { LearnServiceImpl(httpClient = get()) }

    single {
        HttpClient(Android) {
            install(JsonFeature)
            {
                KotlinxSerializer(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )

                engine {
                    connectTimeout = TIME_OUT
                    socketTimeout = TIME_OUT
                }

                install(Logging) {
                    logger = object : Logger {
                        override fun log(message: String) {
                            Timber.tag("HttpLogging:").i(message)
                        }
                    }
                }

                install(ResponseObserver) {
                    onResponse { response ->
                        Timber.i("HTTP status: ${response.status.value}")
                    }
                }

                install(DefaultRequest) {
                    header(HttpHeaders.ContentType, ContentType.Application.Json)
                }
            }
        }
    }
}
