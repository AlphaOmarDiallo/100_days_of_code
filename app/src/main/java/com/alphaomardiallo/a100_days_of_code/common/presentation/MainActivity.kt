package com.alphaomardiallo.a100_days_of_code.common.presentation

import _100_days_of_codeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.Dashboard
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewmodel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !mainViewmodel.state.uiReady
            }
        }

        setContent {
            _100_days_of_codeTheme {
                Dashboard()
            }
        }
    }
}
