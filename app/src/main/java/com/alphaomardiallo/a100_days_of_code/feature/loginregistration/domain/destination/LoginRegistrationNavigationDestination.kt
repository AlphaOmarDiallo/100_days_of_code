package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.destination

import androidx.annotation.StringRes
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.Destination

sealed class LoginRegistrationNavigationDestination(
    @StringRes val resId: Int = 0,
) : Destination(resId.toString()) {

    data object Login : LoginRegistrationNavigationDestination(
        resId = R.string.login_nav_route_login
    )

    data object Registration: LoginRegistrationNavigationDestination(
        resId = R.string.login_nav_route_registration
    )
}
