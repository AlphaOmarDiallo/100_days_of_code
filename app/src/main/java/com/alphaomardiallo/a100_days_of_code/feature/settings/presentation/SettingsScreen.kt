package com.alphaomardiallo.a100_days_of_code.feature.settings.presentation

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SingleLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.smallPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun SettingsScreen(
    navController: NavController? = null,
    viewModel: SettingsViewModel? = koinViewModel()
) {
    SettingsScreenContent() {
        navController?.popBackStack()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SettingsScreenContent(onBackClicked: () -> Unit = {}) {
    var turnOnNotification by remember { mutableStateOf(true) }
    var notificationEveryday by remember { mutableStateOf(true) }
    var notificationMonday by remember { mutableStateOf(true) }
    var notificationTuesday by remember { mutableStateOf(true) }
    var notificationWednesday by remember { mutableStateOf(true) }
    var notificationThursday by remember { mutableStateOf(true) }
    var notificationFriday by remember { mutableStateOf(true) }
    var notificationSaturday by remember { mutableStateOf(true) }
    var notificationSunday by remember { mutableStateOf(true) }

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
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(largePadding())
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(100.dp),
                painter = painterResource(id = R.drawable.sharp_settings_24),
                contentDescription = Icons.Sharp.Settings.name,
                colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary)
            )
            LargeSpacer()
            EmptyCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(largePadding())) {
                    LargeTitle(text = R.string.settings_user_name)
                    MediumSpacer()
                    SingleLineTextFields() { name ->

                    }
                }
            }
            MediumSpacer()

            EmptyCard(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(largePadding())) {
                    LargeTitle(text = R.string.settings_notification)
                    SmallSpacer()

                    BodyText(text = R.string.settings_notification_subtitle)
                    SmallSpacer()

                    // Turn on notification
                    Selector(
                        text = R.string.settings_notification_turn_on,
                        initValue = turnOnNotification
                    ) { bool ->
                        turnOnNotification = bool
                    }

                    if (turnOnNotification) {
                        Row(modifier = Modifier.fillMaxWidth()) {

                        }

                        EmptyCard {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.primaryContainer)
                            ) {
                                // Turn on notification everyday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_everyday,
                                    initValue = notificationEveryday
                                ) { notificationEveryday = it }

                                // Turn on notification monday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_monday,
                                    initValue = notificationMonday
                                ) { notificationMonday = it }

                                // Turn on notification tuesday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_tuesday,
                                    initValue = notificationTuesday
                                ) { notificationTuesday = it }

                                // Turn on notification wednesday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_wednesday,
                                    initValue = notificationWednesday
                                ) { notificationWednesday = it }

                                // Turn on notification thursday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_thursday,
                                    initValue = notificationThursday
                                ) { notificationThursday = it }

                                // Turn on notification friday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_friday,
                                    initValue = notificationFriday
                                ) { notificationFriday = it }

                                // Turn on notification saturday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_saturday,
                                    initValue = notificationSaturday
                                ) { notificationSaturday = it }

                                // Turn on notification sunday
                                Selector(
                                    modifier = Modifier.padding(horizontal = smallPadding()),
                                    text = R.string.settings_notification_sunday,
                                    initValue = notificationSunday
                                ) { notificationSunday = it }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun Selector(
    modifier: Modifier = Modifier,
    text: Int,
    initValue: Boolean,
    onValueChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Title(text = text)
        Switch(
            checked = initValue,
            onCheckedChange = { onValueChange.invoke(it) },
            thumbContent = {
                Image(
                    modifier = Modifier.padding(smallPadding()),
                    imageVector = if (initValue) Icons.Default.Done else Icons.Default.Clear,
                    contentDescription = if (initValue) Icons.Default.Done.name else Icons.Default.Clear.name
                )
            }
        )
    }
    SmallSpacer()
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
