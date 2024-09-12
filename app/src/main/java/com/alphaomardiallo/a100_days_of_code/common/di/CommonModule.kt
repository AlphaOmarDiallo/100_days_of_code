package com.alphaomardiallo.a100_days_of_code.common.di

import com.alphaomardiallo.a100_days_of_code.common.data.local.provideAppDatabase
import com.alphaomardiallo.a100_days_of_code.common.data.local.provideChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.provideUserDao
import com.alphaomardiallo.a100_days_of_code.common.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    // Database
    single { provideAppDatabase(application = get()) }
    single { provideChallengeDao(appDatabase = get()) }
    single { provideUserDao(appDatabase = get()) }
    // Main
    viewModel { MainViewModel() }
}
