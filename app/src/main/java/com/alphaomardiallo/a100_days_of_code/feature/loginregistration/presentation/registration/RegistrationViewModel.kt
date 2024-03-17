package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration

import androidx.lifecycle.ViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.CreateUserWithPasswordAndEmailUseCase
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.SignInOrRegisterWithGithubUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(
    private val createUserWithPasswordAndEmailUseCase: CreateUserWithPasswordAndEmailUseCase,
    private val signInOrRegisterWithGithubUseCase: SignInOrRegisterWithGithubUseCase
): ViewModel() {

    fun createUserWithEmailAndPassword(email: String, password: String){
        createUserWithPasswordAndEmailUseCase.invoke(email = email, password = password)
    }
}
