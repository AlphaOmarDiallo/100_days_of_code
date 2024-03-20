package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login

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
fun LoginScreen() {

    val viewModel: LoginViewModel = hiltViewModel()
    val activity = LocalContext.current as Activity

    LoginScreenContent(
        loginWithEmail = viewModel::signInUserWithEmailAndPassword,
        signInWithGithub = viewModel::signInWithGithub,
        navigateToRegistration = viewModel::navigateToRegistration,
        activity = activity
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenContent(
    loginWithEmail: ((String, String) -> Unit)? = null,
    signInWithGithub: KFunction1<Activity, Unit>? = null,
    navigateToRegistration: () -> Unit = {},
    activity: Activity? = null,
) {
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
            buttonClickAction = loginWithEmail,
            supportTextClickAction = navigateToRegistration,
            type = LoginOrRegistrationType.LOGIN
        )

        LoginWithProvider(
            isLogin = true,
            signInWithProvider = signInWithGithub,
            activity = activity
        )
    }
}
