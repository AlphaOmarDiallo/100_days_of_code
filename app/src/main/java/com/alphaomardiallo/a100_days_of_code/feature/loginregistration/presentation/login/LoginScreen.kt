package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.login

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.util.LoginOrRegistrationType
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable.LoginOrSignInWithEmail
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
@Composable
private fun LoginScreenContent(
    loginWithEmail: ((String, String) -> Unit)? = null,
    signInWithGithub: KFunction1<Activity, Unit>? = null,
    navigateToRegistration: () -> Unit,
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

        LoginWithProvider(signInWithGithub, activity)
    }
}

@Preview
@Composable
private fun AppLogoAndName() {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.2f),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_100_doc),
                contentDescription = stringResource(id = R.string.app_logo_description),
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}

@Composable
private fun LoginWithProvider(signInWithGithub: KFunction1<Activity, Unit>? = null, activity: Activity?) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.login_provider_support_text),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            ProviderBox(link = R.string.login_provider_github_link, description = R.string.login_provider_github_description, signIn = signInWithGithub, activity = activity)
        }
    }
}

@Composable
private fun ProviderBox(link: Int = 0, description: Int = 0, signIn: KFunction1<Activity, Unit>? = null, activity: Activity? = null) {

    Box(
        modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .background(color = Color.Transparent)
            .clickable { activity?.let { signIn?.invoke(it) } }
    ) {
        AsyncImage(
            model = stringResource(id = link),
            contentDescription = stringResource(id = description),
            modifier = Modifier.fillMaxSize()
        )
    }
}
