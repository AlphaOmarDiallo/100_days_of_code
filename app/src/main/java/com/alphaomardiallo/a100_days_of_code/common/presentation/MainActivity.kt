package com.alphaomardiallo.a100_days_of_code.common.presentation

import _100_days_of_codeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.AddEntry
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Dashboard
import com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation.AddEntryScreen
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.DashboardScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            _100_days_of_codeTheme {

                val navController = rememberNavController()
                val currentDest = navController.currentBackStackEntryAsState()

                Surface {
                    NavHost(navController = navController, startDestination = Dashboard) {
                        composable<Dashboard> { DashboardScreen(navController = navController) }
                        composable<AddEntry> { AddEntryScreen(navController = navController) }

                    }
                }
            }
        }
    }
}
