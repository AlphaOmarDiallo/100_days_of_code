package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.CreateUserWithPasswordAndEmailUseCase
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInOrRegisterWithGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val createUserWithPasswordAndEmailUseCase: CreateUserWithPasswordAndEmailUseCase,
    private val signInOrRegisterWithGithubUseCase: SignInOrRegisterWithGithubUseCase,
) : BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    fun createUserWithEmailAndPassword(email: String, password: String) {

        createUserWithPasswordAndEmailUseCase.invoke(email = email, password = password) {
            navToHome()
        }
    }

    fun registerWithGithub(activity: Activity) {
        signInOrRegisterWithGithubUseCase.invoke(activity = activity) {
            navToHome()
        }
    }

    fun navigateToLoginScreen() = navigateTo(LoginRegistrationNavigationDestination.Login.route)

    private fun navToHome() {
        navigateTo(BottomNavDestination.Home.route)
    }
}
