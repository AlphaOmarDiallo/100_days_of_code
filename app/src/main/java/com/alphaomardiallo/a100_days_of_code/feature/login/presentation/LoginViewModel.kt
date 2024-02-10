package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase.CreateUserWithPasswordAndEmail
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase.SignInUserWithEmailAndPasswordUseCase
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase.SignInWithGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserWithEmailAndPasswordUseCase: SignInUserWithEmailAndPasswordUseCase,
    private val createUserWithPasswordAndEmail: CreateUserWithPasswordAndEmail,
    private val signInWithGithubUseCase: SignInWithGithubUseCase
): BaseViewModel() {

    fun signInUserWithEmailAndPassword(email: String, password: String){
        signInUserWithEmailAndPasswordUseCase.invoke(email = email, password = password)
    }

    fun createUserWithEmailAndPassword(email: String, password: String){
        createUserWithPasswordAndEmail.invoke(email = email, password = password)
    }

    fun signInWithGithub(activity: Activity){
        signInWithGithubUseCase.invoke(activity = activity)
    }
}
