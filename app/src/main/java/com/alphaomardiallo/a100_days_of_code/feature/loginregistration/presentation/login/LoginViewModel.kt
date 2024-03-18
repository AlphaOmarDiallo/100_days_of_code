package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login

import android.app.Activity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInUserWithEmailAndPasswordUseCase
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInOrRegisterWithGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserWithEmailAndPasswordUseCase: SignInUserWithEmailAndPasswordUseCase,
    private val signInOrRegisterWithGithubUseCase: SignInOrRegisterWithGithubUseCase
): BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////

    var loginState by mutableStateOf(LoginUiState())
        private set

    ///////////////////////////////////////////////////////////////////////////
    // Public functions
    ///////////////////////////////////////////////////////////////////////////

    fun signInUserWithEmailAndPassword(email: String, password: String){
        val result = signInUserWithEmailAndPasswordUseCase.invoke(email = email, password = password)
        updateLoginState(result)
    }

    fun signInWithGithub(activity: Activity){
        val result = signInOrRegisterWithGithubUseCase.invoke(activity = activity, ::navigateToApp)
        updateLoginState(result)
    }

    fun navigateToRegistration() = navigateTo(LoginRegistrationNavigationDestination.Registration.route)

    ///////////////////////////////////////////////////////////////////////////
    // Private functions
    ///////////////////////////////////////////////////////////////////////////
    private fun updateLoginState(result: Boolean) {
        loginState = loginState.copy(isLoggedIn = result)
    }
}
