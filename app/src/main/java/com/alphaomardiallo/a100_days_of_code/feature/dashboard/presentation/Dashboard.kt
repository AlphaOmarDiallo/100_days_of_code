package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.DialogProperties
import com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation.OnBoarding
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(viewModel: DashboardViewModel = koinViewModel()){
    val uiState = viewModel.state
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(uiState.shouldShowOnboarding) {
        showDialog = uiState.shouldShowOnboarding == true
    }

    if (showDialog) {
        BasicAlertDialog(
            onDismissRequest = { showDialog = false },
            modifier = Modifier.fillMaxSize(),
            properties = DialogProperties(usePlatformDefaultWidth = false)
        ) {
            Surface(modifier = Modifier.fillMaxSize()) {
                OnBoarding {
                    showDialog = false
                }
            }
        }
    }
}
