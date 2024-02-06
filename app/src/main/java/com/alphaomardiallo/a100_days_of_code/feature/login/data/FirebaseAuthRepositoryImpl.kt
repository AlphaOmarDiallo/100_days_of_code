package com.alphaomardiallo.a100_days_of_code.feature.login.data

import android.app.Activity
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository.FirebaseAuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import javax.inject.Inject
import timber.log.Timber

class FirebaseAuthRepositoryImpl @Inject constructor() : FirebaseAuthRepository {

    private var auth: FirebaseAuth? = null

    private var user: FirebaseUser? = null

    override fun initializeFirebaseAuth() {
        auth = Firebase.auth
    }

    override fun getCurrentUser(): FirebaseUser? {
        user = auth?.currentUser
        return user
    }

    override fun createUserWithEmailAndPassword(email: String, password: String): Boolean {
        auth?.createUserWithEmailAndPassword(email, password)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                auth!!.currentUser!!.sendEmailVerification().addOnCompleteListener { taskEmail ->
                    if (taskEmail.isSuccessful) {
                        Timber.d("[FirebaseAuth] : verification email sent")
                        user = auth?.currentUser
                        Timber.d("[FirebaseAuth] : create user with email successful")
                    } else {
                        Timber.w("[FirebaseAuth] : verification email no sent")
                    }
                }
            } else {
                Timber.w("[FirebaseAuth] : create user with email unsuccessful")
            }
        }

        return auth?.currentUser != null
    }

    override fun signInUserWithEmailAndPassword(email: String, password: String): Boolean {
        auth?.signInWithEmailAndPassword(email, password)?.addOnCompleteListener { task ->
            if (task.isSuccessful) {
                user = auth?.currentUser
                Timber.d("[FirebaseAuth] : sign in user with email successful")

            } else {
                Timber.w("[FirebaseAuth] : sign in user with email unsuccessful")
            }
        }

        return auth?.currentUser != null
    }

    override fun signInWithGithub(activity: Activity) {
        val provider = OAuthProvider.newBuilder("github.com")

        val pendingResultTask = auth?.pendingAuthResult

        if (pendingResultTask != null) {
            pendingResultTask
                .addOnSuccessListener {
                    Timber.d("[FirebaseAuth] : sign in user with github awaiting result")
                }
                .addOnFailureListener {
                    Timber.w("[FirebaseAuth] : sign in user with github result failed")
                }
        } else {
            // Start sign in here

            auth?.startActivityForSignInWithProvider(activity, provider.build())
                ?.addOnSuccessListener {
                    Timber.d("[FirebaseAuth] : sign in user with github successful")
                }
                ?.addOnFailureListener {
                    Timber.w("[FirebaseAuth] : sign in user with github unsuccessful")
                }
        }
    }
}
