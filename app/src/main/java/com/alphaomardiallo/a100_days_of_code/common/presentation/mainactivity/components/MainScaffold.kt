package com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScaffold(
    navController: NavHostController,
    navBackStackEntry: NavBackStackEntry?,
    navItems: List<BottomNavDestination>,
    content: @Composable (PaddingValues) -> Unit,
) {

    var showNavigationBar by rememberSaveable { mutableStateOf(false) }
    var selectedBarItem by rememberSaveable { mutableStateOf(0) }
    var currentRoute by rememberSaveable { mutableStateOf(BottomNavDestination.Home.route) }

    navBackStackEntry?.destination?.route?.let { route ->
        showNavigationBar = when (route) {
            BottomNavDestination.Home.route,
            BottomNavDestination.History.route,
            BottomNavDestination.Community.route,
            BottomNavDestination.Menu.route,
            -> true

            else -> false
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                isNavigationBarVisible = showNavigationBar,
                items = navItems,
                currentRoute = currentRoute,
                selectedItemIndex = selectedBarItem,
                onSelectedItemChange = { index ->
                    selectedBarItem = index
                }
            ) { route ->
                currentRoute = route
                navController.navigate(route) {
                    navController.graph.startDestinationRoute?.let { route ->
                        popUpTo(route = route) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }

            }
        }
    ) { paddingValues ->
        content(paddingValues)
    }
}
