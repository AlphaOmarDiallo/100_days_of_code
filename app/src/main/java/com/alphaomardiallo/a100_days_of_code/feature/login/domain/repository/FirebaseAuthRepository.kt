package com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository

import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthRepository {

    fun initializeFirebaseAuth()

    fun getCurrentUser(): FirebaseUser?

    fun createUserWithEmailAndPassword(email: String, password: String): Boolean

    fun signInUserWithEmailAndPassword(email: String, password: String): Boolean
}