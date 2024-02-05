package com.alphaomardiallo.a100_days_of_code.feature.login.data

import com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository.FirebaseAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor() : FirebaseAuthRepository {

    private var auth: FirebaseAuth? = null

    override fun initializeFirebaseAuth() {
        auth = Firebase.auth
    }

    override fun getCurrentUser(): FirebaseUser? = auth?.currentUser
}
