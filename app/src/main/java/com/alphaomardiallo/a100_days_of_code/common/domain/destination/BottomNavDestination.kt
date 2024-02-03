package com.alphaomardiallo.a100_days_of_code.common.domain.destination

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.alphaomardiallo.a100_days_of_code.R

sealed class BottomNavDestination(
    val icon: ImageVector,
    @StringRes val resId: Int = 0
): Destination(resId.toString()) {

    data object Home : BottomNavDestination(
        icon = Icons.Default.Home,
        resId = R.string.bottom_nav_route_home
    )

    data object History : BottomNavDestination(
        icon = Icons.Default.List,
        resId = R.string.bottom_nav_route_history
    )

    data object Community : BottomNavDestination(
        icon = Icons.Default.Person,
        resId = R.string.bottom_nav_route_community
    )

    data object Menu : BottomNavDestination(
        icon = Icons.Default.Person,
        resId = R.string.bottom_nav_route_menu
    )
}
