package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.alphaomardiallo.a100_days_of_code.feature.login.domain.destination.LoginNavigationDestination

fun NavGraphBuilder.loginNavigation(): NavGraphBuilder = this.apply {
    composable(route = LoginNavigationDestination.Login.route){
        LoginScreen()
    }
}