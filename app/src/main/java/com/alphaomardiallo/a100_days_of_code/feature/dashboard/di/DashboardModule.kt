package com.alphaomardiallo.a100_days_of_code.feature.dashboard.di

import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dashboardModule = module {
    viewModel { DashboardViewModel(userRepository = get(), challengeRepository = get()) }
}
