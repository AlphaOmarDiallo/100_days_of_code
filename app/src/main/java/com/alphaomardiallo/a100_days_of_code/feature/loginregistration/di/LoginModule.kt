package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.di

import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.repository.FirebaseAuthRepository
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.data.FirebaseAuthRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class LoginModule {

    @Binds
    @Singleton
    abstract fun bindFirebaseAuthRepository(firebaseAuthRepositoryImpl: FirebaseAuthRepositoryImpl): FirebaseAuthRepository
}
