package com.alphaomardiallo.a100_days_of_code.feature.login.di

import com.alphaomardiallo.a100_days_of_code.feature.login.domain.repository.FirebaseAuthRepository
import com.alphaomardiallo.a100_days_of_code.feature.login.data.FirebaseAuthRepositoryImpl
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
