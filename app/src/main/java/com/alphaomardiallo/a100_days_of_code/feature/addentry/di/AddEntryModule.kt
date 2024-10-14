package com.alphaomardiallo.a100_days_of_code.feature.addentry.di

import com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation.AddEntryViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val addEntryModule = module {
    viewModel { AddEntryViewModel(challengeRepository = get()) }
}
