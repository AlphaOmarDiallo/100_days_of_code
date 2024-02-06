package com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class SignInWithGithubUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {

    fun invoke(activity: Activity) = firebaseAuthRepository.signInWithGithub(activity)
}
