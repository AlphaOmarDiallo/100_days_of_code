package com.alphaomardiallo.a100_days_of_code.feature.login.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.EmailValidator.isValidEmail
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.PasswordValidator.isValidPassword
import timber.log.Timber

@Preview(showBackground = true)
@Composable
fun LoginScreen() {

    val viewModel: LoginViewModel = hiltViewModel()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppLogoAndName()
        LoginOrSignInWithEmail(viewModel::signInUserWithEmailAndPassword)
    }
}

@Composable
private fun AppLogoAndName() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.3f),
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
private fun LoginOrSignInWithEmail(loginWithEmail: (String, String) -> Unit) {

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
        )

        OutlinedTextField(
            modifier = Modifier.padding(8.dp),
            value = textValuePassword,
            onValueChange = {
                textValuePassword= it
            },
            label = {
                Text(text = stringResource(id = R.string.login_password_label))
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Text(
            modifier= Modifier
                .padding(4.dp)
                .clickable { Timber.d("forgotten password clicked") },
            text = stringResource(id = R.string.login_reset_password)
        )

        Button(
            onClick = { loginWithEmail.invoke(textValueEmail, textValuePassword) },
            enabled = isValidEmail(textValueEmail) && isValidPassword(textValuePassword)
        ) {
            Text(text = stringResource(id = R.string.login_login_button))
        }
    }
}