package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.registration

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.util.LoginOrRegistrationType
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable.AppLogoAndName
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable.LoginOrSignInWithEmail
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable.LoginWithProvider
import kotlin.reflect.KFunction1

@Composable
fun RegistrationScreen() {

    val viewModel: RegistrationViewModel = hiltViewModel()
    val activity = LocalContext.current as Activity

    RegistrationScreenContent(
        registerWithEmail = viewModel::createUserWithEmailAndPassword,
        registerWithGithub = viewModel::registerWithGithub,
        navigateToLogin = viewModel::navigateToLoginScreen,
        activity = activity
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun RegistrationScreenContent(
    registerWithEmail: ((String, String) -> Unit)? = null,
    registerWithGithub: KFunction1<Activity, Unit>? = null,
    navigateToLogin: () -> Unit = {},
    activity: Activity? = null,
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogoAndName()

        LoginOrSignInWithEmail(
            buttonClickAction = registerWithEmail,
            supportTextClickAction = navigateToLogin,
            type = LoginOrRegistrationType.LOGIN
        )

        LoginWithProvider(registerWithGithub, activity)
    }
}
