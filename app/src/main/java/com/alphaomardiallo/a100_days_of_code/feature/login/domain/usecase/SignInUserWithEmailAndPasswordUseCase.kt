package com.alphaomardiallo.a100_days_of_code.feature.login.domain.usecase

import com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class SignInUserWithEmailAndPasswordUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {

    fun invoke(email: String, password: String) = firebaseAuthRepository.signInUserWithEmailAndPassword(email, password)
}
