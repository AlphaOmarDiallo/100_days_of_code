package com.alphaomardiallo.a100_days_of_code.feature.settings

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SingleLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding

@Composable
fun SettingsScreen(navController: NavController? = null) {
    SettingsScreenContent() {
        navController?.popBackStack()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsScreenContent(onBackClicked: () -> Unit = {}) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.padding(horizontal = largePadding()),
                        text = R.string.settings_title
                    )
                },
                navigationIcon = {
                    SmallIconButton {
                        onBackClicked.invoke()
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.surfaceContainerHighest,
                    titleContentColor = MaterialTheme.colorScheme.onSurface,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(largePadding())
        ) {
            EmptyCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(largePadding())) {
                    LargeTitle(text = R.string.settings_user_name)
                    MediumSpacer()
                    SingleLineTextFields() { name ->

                    }
                }
            }
            LargeSpacer()
            EmptyCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(largePadding())) {
                    LargeTitle(text = R.string.settings_notification)
                    MediumSpacer()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RulesPreview() {
    Theme_100DOC {
        Surface {
            SettingsScreenContent()
        }
    }
}
