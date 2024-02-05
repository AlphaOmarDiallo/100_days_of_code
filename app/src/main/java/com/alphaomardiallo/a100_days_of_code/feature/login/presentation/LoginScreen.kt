package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

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
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.EmailValidator.isValidEmail
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.PasswordValidator.isValidPassword
import timber.log.Timber


@Composable
fun LoginScreen() {

    val viewModel: LoginViewModel = hiltViewModel()

    LoginScreenContent(
        loginWithEmail = viewModel::signInUserWithEmailAndPassword,
        registerWithEmail = viewModel::createUserWithEmailAndPassword
    )

}

@Preview(showBackground = true)
@Composable
fun LoginScreenContent(
    loginWithEmail: ((String, String) -> Unit)? = null,
    registerWithEmail: ((String, String) -> Unit)? = null,
) {

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogoAndName()

        LoginOrSignInWithEmail(
            loginWithEmail = loginWithEmail,
            registerWithEmail = registerWithEmail
        )

        LoginWithProvider()
    }
}

@Composable
private fun AppLogoAndName() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.2f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo_100_doc),
            contentDescription = stringResource(id = R.string.app_logo_description)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun LoginOrSignInWithEmail(
    loginWithEmail: ((String, String) -> Unit)? = null,
    registerWithEmail: ((String, String) -> Unit)? = null,
) {

    var textValueEmail by remember { mutableStateOf("") }
    var textValuePassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = textValueEmail,
            onValueChange = {
                textValueEmail = it
            },
            label = {
                Text(text = stringResource(id = R.string.login_email_label))
            },
            supportingText = {
                Text(
                    text = if (textValueEmail.length > 2 && !isValidEmail(textValueEmail)) {
                        stringResource(id = R.string.login_invalid_email)
                    } else {
                        ""
                    },
                    color = MaterialTheme.colorScheme.error
                )
            }
        )

        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = textValuePassword,
            onValueChange = {
                textValuePassword = it
            },
            label = {
                Text(text = stringResource(id = R.string.login_password_label))
            },
            visualTransformation = PasswordVisualTransformation(),
            supportingText = {
                Text(
                    text = if (textValuePassword.length > 1 && !isValidPassword(textValuePassword)) {
                        stringResource(id = R.string.login_invalid_password)
                    } else {
                        ""
                    },
                    color = MaterialTheme.colorScheme.error
                )
            }
        )

        Text(
            modifier = Modifier
                .padding(4.dp)
                .clickable { Timber.d("forgotten password clicked") },
            text = stringResource(id = R.string.login_reset_password)
        )

        Button(
            onClick = { loginWithEmail?.invoke(textValueEmail, textValuePassword) },
            enabled = isValidEmail(textValueEmail) && isValidPassword(textValuePassword)
        ) {
            Text(text = stringResource(id = R.string.login_login_button))
        }

        Divider(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp)
        )

        Text(text = stringResource(id = R.string.login_register_support_text), modifier = Modifier.padding(8.dp))

        OutlinedButton(
            onClick = { registerWithEmail?.invoke(textValueEmail, textValuePassword) },
            enabled = isValidEmail(textValueEmail) && isValidPassword(textValuePassword)
        ) {
            Text(text = stringResource(id = R.string.login_register_button))
        }
    }
}

@Composable
private fun LoginWithProvider() {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
            ProviderBox(link = R.string.login_provider_google_link, description = R.string.login_provider_google_description)
            ProviderBox(link = R.string.login_provider_github_link, description = R.string.login_provider_github_description)
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun ProviderBox(link: Int = 0, description: Int = 0) {
    Box(
        modifier = Modifier
            .height(60.dp)
            .width(60.dp)
            .background(color = Color.Transparent)
    ) {
        AsyncImage(
            model = stringResource(id = link),
            contentDescription = stringResource(id = description),
            modifier = Modifier.fillMaxSize()
        )
    }
}
