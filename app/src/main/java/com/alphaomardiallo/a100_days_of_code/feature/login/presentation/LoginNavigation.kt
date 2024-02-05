package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

import androidx.activity.compose.BackHandler
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.destination.LoginNavigationDestination
import timber.log.Timber

fun NavGraphBuilder.loginNavigation(): NavGraphBuilder = this.apply {
    composable(route = LoginNavigationDestination.Login.route) {
        BackHandler(true) {
            Timber.i("[LoginScreenNav] Clicked back")
        }
        LoginScreen()
    }
}
