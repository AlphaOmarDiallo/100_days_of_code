package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.navigation

import androidx.activity.compose.BackHandler
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination.LoginRegistrationNavigationDestination
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login.LoginScreen
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration.RegistrationScreen
import timber.log.Timber

fun NavGraphBuilder.loginNavigation(): NavGraphBuilder = this.apply {
    composable(route = LoginRegistrationNavigationDestination.Login.route) {
        BackHandler(true) {
            Timber.i("[LoginScreenNav] Clicked back")
        }
        LoginScreen()
    }

    composable(route = LoginRegistrationNavigationDestination.Registration.route) {
        BackHandler(true) {
            Timber.i("[LoginScreenNav] Clicked back")
        }
        RegistrationScreen()
    }
}
