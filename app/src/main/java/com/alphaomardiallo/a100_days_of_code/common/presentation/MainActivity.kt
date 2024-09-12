package com.alphaomardiallo.a100_days_of_code.common.presentation

import _100_days_of_codeTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.Dashboard
import com.alphaomardiallo.a100_days_of_code.feature.firststart.presentation.FirstStart
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewmodel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                !mainViewmodel.state.uiReady
            }
        }
        enableEdgeToEdge()
        setContent {
            val uiState = mainViewmodel.state

            _100_days_of_codeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    if (uiState.shouldShowOnboarding){
                        FirstStart(paddingValues = innerPadding)
                    } else {
                        Dashboard(paddingValues = innerPadding)
                    }
                }
            }
        }
    }
}
