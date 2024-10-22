package com.alphaomardiallo.a100_days_of_code.feature.history.di

import com.alphaomardiallo.a100_days_of_code.feature.history.presentation.HistoryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val historyModule = module {
    viewModel { HistoryViewModel(challengeRepository = get()) }
}
