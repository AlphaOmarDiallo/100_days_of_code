package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class SignInOrRegisterWithGithubUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {

    fun invoke(activity: Activity, navigate: () -> Unit) = firebaseAuthRepository.signInOrRegisterWithGithub(activity, navigate)
}
