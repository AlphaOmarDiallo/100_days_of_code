package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.repository

import android.app.Activity
import com.google.firebase.auth.FirebaseUser

interface FirebaseAuthRepository {

    fun initializeFirebaseAuth()

    fun getCurrentUser(): FirebaseUser?

    fun createUserWithEmailAndPassword(email: String, password: String, result: () -> Unit): Boolean

    fun signInUserWithEmailAndPassword(email: String, password: String, result: () -> Unit): Boolean

    fun signInOrRegisterWithGithub(activity: Activity, result: () -> Unit): Boolean

    fun logOut(): Boolean
}