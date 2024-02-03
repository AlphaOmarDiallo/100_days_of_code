package com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.a100_days_of_code.common.domain.destination.BottomNavDestination
import com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity.components.MainScaffold
import com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity.destination.NavigationEffects
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme._100_days_of_codeTheme
import com.alphaomardiallo.a100_days_of_code.feature.community.CommunityScreen
import com.alphaomardiallo.a100_days_of_code.feature.history.HistoryScreen
import com.alphaomardiallo.a100_days_of_code.feature.home.HomeScreen
import com.alphaomardiallo.a100_days_of_code.feature.menu.MenuScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val navBarItems = listOf(
            BottomNavDestination.Home,
            BottomNavDestination.History,
            BottomNavDestination.Community,
            BottomNavDestination.Menu,
        )

        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            NavigationEffects(navigationChannel = viewModel.navigationChannel, navHostController = navController)

            _100_days_of_codeTheme {
                // A surface container using the 'background' color from the theme

                MainScaffold(
                    navController = navController, navBackStackEntry = navBackStackEntry, navItems = navBarItems
                ) { paddingValues ->

                    Surface(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(paddingValues), color = MaterialTheme.colorScheme.background
                    ) {

                        NavHost(
                            navController = navController, startDestination = BottomNavDestination.Home.route
                        ) {
                            bottomBarNavigation()
                        }
                    }
                }

            }
        }
    }

    private fun NavGraphBuilder.bottomBarNavigation(): NavGraphBuilder = this.apply {
        composable(route = BottomNavDestination.Home.route) {
            HomeScreen()
        }
        composable(route = BottomNavDestination.History.route) {
            HistoryScreen()
        }
        composable(route = BottomNavDestination.Community.route) {
            CommunityScreen()
        }
        composable(route = BottomNavDestination.Menu.route) {
            MenuScreen()
        }
    }
}
