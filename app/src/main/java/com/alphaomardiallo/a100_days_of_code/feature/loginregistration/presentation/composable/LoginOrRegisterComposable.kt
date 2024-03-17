package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.EmailValidator
import com.alphaomardiallo.a100_days_of_code.common.domain.validator.PasswordValidator
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme._100_days_of_codeTheme
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.util.LoginOrRegistrationType
import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginOrSignInWithEmail(
    buttonClickAction: ((String, String) -> Unit)? = null,
    supportTextClickAction: () -> Unit,
    type: LoginOrRegistrationType = LoginOrRegistrationType.REGISTRATION,
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
                    text = if (textValueEmail.length > 2 && !EmailValidator.isValidEmail(
                            textValueEmail
                        )
                    ) {
                        stringResource(id = R.string.login_invalid_email)
                    } else {
                        ""
                    },
                    color = MaterialTheme.colorScheme.error
                )
            }
        )

        OutlinedTextField(
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 8.dp),
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
                    text = if (textValuePassword.length > 1 && !PasswordValidator.isValidPassword(
                            textValuePassword
                        )
                    ) {
                        stringResource(id = R.string.login_invalid_password)
                    } else {
                        ""
                    },
                    color = MaterialTheme.colorScheme.error
                )
            }
        )

        if (type == LoginOrRegistrationType.LOGIN){
            Text(
                modifier = Modifier
                    .padding(4.dp)
                    .clickable { Timber.d("forgotten password clicked") },
                text = stringResource(id = R.string.login_reset_password)
            )

            Button(
                onClick = { buttonClickAction?.invoke(textValueEmail, textValuePassword) },
                enabled = EmailValidator.isValidEmail(textValueEmail) && PasswordValidator.isValidPassword(
                    textValuePassword
                )
            ) {
                Text(text = stringResource(id = R.string.login_login_button))
            }

        } else {
            OutlinedButton(
                onClick = { buttonClickAction?.invoke(textValueEmail, textValuePassword) },
                enabled = EmailValidator.isValidEmail(textValueEmail) && PasswordValidator.isValidPassword(
                    textValuePassword
                )
            ) {
                Text(text = stringResource(id = R.string.login_register_button))
            }
        }

        Spacer(modifier = Modifier.padding(8.dp))

        SupportText(
            supportTextClickAction = supportTextClickAction,
            type = type
        )

        Divider(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp)
        )
    }
}

@Composable
private fun SupportText(
    supportTextClickAction: () -> Unit,
    type: LoginOrRegistrationType
) {
    val res = if (type == LoginOrRegistrationType.REGISTRATION){
        R.string.login_register_support_text_two
    } else {
        R.string.login_register_support_text
    }

    Text(
        text = stringResource(id = res),
        style = MaterialTheme.typography.titleMedium.copy(color = MaterialTheme.colorScheme.primary),
        modifier = Modifier
            .padding(8.dp)
            .clickable { supportTextClickAction.invoke() }
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewLoginWithEmail() {
    _100_days_of_codeTheme {
        LoginOrSignInWithEmail(
            buttonClickAction = null,
            supportTextClickAction = {},
            type = LoginOrRegistrationType.LOGIN
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun PreviewRegistrationWithEmail() {
    _100_days_of_codeTheme {
        LoginOrSignInWithEmail(
            buttonClickAction = null,
            supportTextClickAction = {},
            type = LoginOrRegistrationType.REGISTRATION
        )
    }
}
