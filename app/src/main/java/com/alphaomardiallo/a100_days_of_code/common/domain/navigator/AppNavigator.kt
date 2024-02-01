package com.alphaomardiallo.a100_days_of_code.common.domain.navigator

import kotlinx.coroutines.channels.Channel

interface AppNavigator {

    val navigationChannel: Channel<NavigationIntent>

    suspend fun navigateBack(
        route: String? = null,
        inclusive: Boolean = false,
    )

    suspend fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    )
}
