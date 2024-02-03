package com.alphaomardiallo.a100_days_of_code.common.domain.destination

import androidx.navigation.NamedNavArgument

open class Destination(
    val route: String,
    val args: List<NamedNavArgument> = emptyList()
)
