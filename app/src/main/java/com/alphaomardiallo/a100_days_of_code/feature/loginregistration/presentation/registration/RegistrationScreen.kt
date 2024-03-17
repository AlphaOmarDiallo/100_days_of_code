package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun RegistrationScreen() {

    val viewModel: RegistrationViewModel = hiltViewModel()
    val activity = LocalContext.current as Activity
}