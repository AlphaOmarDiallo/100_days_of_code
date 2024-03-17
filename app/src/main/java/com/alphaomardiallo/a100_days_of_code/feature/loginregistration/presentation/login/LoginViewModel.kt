package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login

import android.app.Activity
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

    fun signInUserWithEmailAndPassword(email: String, password: String){
        signInUserWithEmailAndPasswordUseCase.invoke(email = email, password = password)
    }

    fun signInWithGithub(activity: Activity){
        signInOrRegisterWithGithubUseCase.invoke(activity = activity, ::navigateToApp)
    }

    fun navigateToRegistration() = navigateTo(LoginRegistrationNavigationDestination.Registration.route)
}
