package com.alphaomardiallo.a100_days_of_code.feature.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.alphaomardiallo.a100_days_of_code.R
import kotlin.reflect.KFunction0

@Composable
fun MenuScreen() {
    val viewModel: SettingsViewModel = hiltViewModel()

    LoginScreenContent(viewModel::signOut)
}

@Composable
fun LoginScreenContent(signOut: KFunction0<Unit>) {
    Column {

        Button(onClick = { signOut.invoke() }) {
            Text(text = stringResource(id = R.string.bottom_nav_route_settings))
        }
    }

}