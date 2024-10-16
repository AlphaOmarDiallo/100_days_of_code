package com.alphaomardiallo.a100_days_of_code.common.di

import com.alphaomardiallo.a100_days_of_code.common.data.local.provideAppDatabase
import com.alphaomardiallo.a100_days_of_code.common.data.local.provideChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.provideUserDao
import com.alphaomardiallo.a100_days_of_code.common.data.repository.ChallengeRepositoryImp
import com.alphaomardiallo.a100_days_of_code.common.data.repository.UserRepositoryImp
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.usecase.StringDateToMillis
import com.alphaomardiallo.a100_days_of_code.common.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    // Database
    single { provideAppDatabase(application = get()) }
    single { provideChallengeDao(appDatabase = get()) }
    single { provideUserDao(appDatabase = get()) }

    // Repository
    single<ChallengeRepository> { ChallengeRepositoryImp(challengeDao = get()) }
    single<UserRepository> { UserRepositoryImp(userDao = get()) }

    // UseCase
    single { StringDateToMillis() }

    // Main
    viewModel { MainViewModel() }
}
