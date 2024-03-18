package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInOrRegisterWithGithubUseCase
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInUserWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserWithEmailAndPasswordUseCase: SignInUserWithEmailAndPasswordUseCase,
    private val signInOrRegisterWithGithubUseCase: SignInOrRegisterWithGithubUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    fun signInUserWithEmailAndPassword(email: String, password: String) {
        signInUserWithEmailAndPasswordUseCase.invoke(email = email, password = password) {
            navigateToHome()
        }
    }

    fun signInWithGithub(activity: Activity) {
        signInOrRegisterWithGithubUseCase.invoke(activity = activity) {
            navigateTo(BottomNavDestination.Home.route)
        }
    }

    fun navigateToRegistration() =
        navigateTo(LoginRegistrationNavigationDestination.Registration.route)

    fun navigateToHome() = navigateTo(BottomNavDestination.Home.route)
}
