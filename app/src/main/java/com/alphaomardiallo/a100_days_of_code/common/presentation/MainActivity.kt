package com.alphaomardiallo.a100_days_of_code.common.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.AddEntry
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Dashboard
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.History
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Info
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Learning
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Rules
import com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation.AddEntryScreen
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.DashboardScreen
import com.alphaomardiallo.a100_days_of_code.feature.history.presentation.HistoryScreen
import com.alphaomardiallo.a100_days_of_code.feature.info.presentation.InfoScreen
import com.alphaomardiallo.a100_days_of_code.feature.learn.presentation.LearningScreen
import com.alphaomardiallo.a100_days_of_code.feature.rules.presentation.RulesScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            Theme_100DOC {
                val navController = rememberNavController()

                Surface {
                    NavHost(navController = navController, startDestination = Dashboard) {
                        composable<Dashboard> { DashboardScreen(navController = navController) }
                        composable<AddEntry> { AddEntryScreen(navController = navController) }
                        composable<Info> { InfoScreen(navController = navController) }
                        composable<Learning> { LearningScreen(navController = navController) }
                        composable<Rules> { RulesScreen(navController = navController) }
                        composable<History> { HistoryScreen(navController = navController) }
                    }
                }
            }
        }
    }
}
