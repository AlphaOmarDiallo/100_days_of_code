package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.getPreviewChallenges
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.getPreviewUser
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable.DashboardTitleSection
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable.ProgressSection
import com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation.OnBoarding
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Dashboard(viewModel: DashboardViewModel = koinViewModel()) {
    val uiState = viewModel.uiState.collectAsStateWithLifecycle()
    var showDialog by remember { mutableStateOf(false) }

    LaunchedEffect(uiState.value.user) {
        if (uiState.value.user != null) {
            viewModel.getChallenges()
        }
    }

    DashboardContent(
        user = uiState.value.user,
        challenges = uiState.value.challenges
    ) {
        showDialog = true
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

@Composable
private fun DashboardContent(
    user: User? = null, challenges: List<Challenge?> = emptyList(), showDialog: () -> Unit = {}
) {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(largePadding())
    ) {
        // Welcome section
        DashboardTitleSection(user = user)
        // Current progress section
        ProgressSection(challenges = challenges, user = user) {
            showDialog.invoke()
        }
    }
}

@Composable
private fun DashboardContentPreview() {
    DashboardContent(
        user = getPreviewUser(),
        challenges = getPreviewChallenges()
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DashboardPreview() {
    _100_days_of_codeTheme {
        Surface {
            DashboardContentPreview()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DashboardDarkPreview() {
    _100_days_of_codeTheme {
        Surface {
            DashboardContentPreview()
        }
    }
}
