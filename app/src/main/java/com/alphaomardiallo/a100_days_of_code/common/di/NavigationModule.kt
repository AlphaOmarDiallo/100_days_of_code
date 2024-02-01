package com.alphaomardiallo.a100_days_of_code.common.di

import com.alphaomardiallo.a100_days_of_code.common.domain.navigator.AppNavigator
import com.alphaomardiallo.a100_days_of_code.common.domain.navigator.AppNavigatorImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class NavigationModule {

    @Binds
    @Singleton
    abstract fun bindAppNavigator(appNavigatorImpl: AppNavigatorImpl): AppNavigator

}
