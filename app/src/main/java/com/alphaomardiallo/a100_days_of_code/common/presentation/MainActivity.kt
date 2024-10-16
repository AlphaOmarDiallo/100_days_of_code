package com.alphaomardiallo.a100_days_of_code.common.presentation

import _100_days_of_codeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.Dashboard

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen()

        setContent {
            _100_days_of_codeTheme {
                Surface {
                    Dashboard()
                }
            }
        }
    }
}
