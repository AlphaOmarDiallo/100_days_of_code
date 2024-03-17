package com.alphaomardiallo.a100_days_of_code.feature.settings

import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignOutUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val signOutUseCase: SignOutUseCase
): BaseViewModel() {

    fun signOut(){
        if (signOutUseCase.invoke()) {
            navigateTo(LoginRegistrationNavigationDestination.Login.route)
        }
    }
}
