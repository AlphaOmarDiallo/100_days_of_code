package com.alphaomardiallo.a100_days_of_code.feature.settings.di

import com.alphaomardiallo.a100_days_of_code.feature.settings.presentation.SettingsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val settingsModule = module {
    viewModel { SettingsViewModel(userRepository = get()) }
}
