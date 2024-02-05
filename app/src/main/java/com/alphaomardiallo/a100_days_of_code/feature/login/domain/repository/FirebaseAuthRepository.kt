package com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthRepository {

    fun initializeFirebaseAuth()

    fun getCurrentUser(): FirebaseUser?
}