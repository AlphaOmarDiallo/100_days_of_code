package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase

import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.repository.FirebaseAuthRepository
import javax.inject.Inject

class SignOutUseCase @Inject constructor(
    private val firebaseAuthRepository: FirebaseAuthRepository
) {

    fun invoke() = firebaseAuthRepository.logOut()
}
