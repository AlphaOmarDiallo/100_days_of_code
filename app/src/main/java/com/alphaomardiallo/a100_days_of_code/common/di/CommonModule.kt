package com.alphaomardiallo.a100_days_of_code.common.di

import com.alphaomardiallo.a100_days_of_code.common.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val commonModule = module {
    viewModel { MainViewModel() }
}
