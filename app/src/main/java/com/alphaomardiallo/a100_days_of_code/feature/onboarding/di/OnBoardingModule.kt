package com.alphaomardiallo.a100_days_of_code.feature.onboarding.di

import com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation.OnBoardingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val onBoardingModule = module {
    viewModel<OnBoardingViewModel> {
        OnBoardingViewModel(
            userRepository = get(),
            challengeRepository = get()
        )
    }
}
