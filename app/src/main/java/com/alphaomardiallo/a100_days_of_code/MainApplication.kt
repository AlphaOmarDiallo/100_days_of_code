package com.alphaomardiallo.a100_days_of_code

import android.app.Application
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.usecase.InitializeFirebaseAuthUseCase
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class MainApplication: Application() {

   @Inject lateinit var initializeFirebaseAuthUseCase: InitializeFirebaseAuthUseCase

   override fun onCreate() {
      super.onCreate()

      if (BuildConfig.DEBUG){
         plant(Timber.DebugTree())
      }

      FirebaseApp.initializeApp(this)
      initializeFirebaseAuthUseCase.invoke()
   }

}
