package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

import androidx.lifecycle.ViewModel
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase.SignInUserWithEmailAndPasswordUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val signInUserWithEmailAndPasswordUseCase: SignInUserWithEmailAndPasswordUseCase
): ViewModel() {

    fun signInUserWithEmailAndPassword(email: String, password: String){
        signInUserWithEmailAndPasswordUseCase.invoke(email, password)
    }
}
