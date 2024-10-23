package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.List
import androidx.compose.material.icons.sharp.Build
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Settings
import androidx.compose.material.icons.sharp.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.History
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Info
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Learning
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Rules
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.Settings

private const val CardHeight = 70

@Composable
fun LinkSection(navController: NavController? = null) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = mediumPadding())
    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Card(
                modifier = Modifier.weight(1f),
                click = { navController?.navigate(History) },
                backgroundColor = MaterialTheme.colorScheme.secondaryContainer
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Sharp.List,
                        contentDescription = Icons.AutoMirrored.Sharp.List.name,
                        tint = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                    SmallSpacer()
                    Title(
                        text = R.string.info_button_history,
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                }
            }
            SmallSpacer()
            Card(
                modifier = Modifier.weight(1f),
                click = { navController?.navigate(Learning) },
                backgroundColor = MaterialTheme.colorScheme.primary
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Sharp.Build,
                        contentDescription = Icons.Sharp.Build.name,
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                    SmallSpacer()
                    Title(
                        text = R.string.info_button_resources,
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                }
            }
        }
        SmallSpacer()
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
            Card(
                modifier = Modifier.weight(1f),
                click = { navController?.navigate(Rules) },
                backgroundColor = MaterialTheme.colorScheme.secondary
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        imageVector = Icons.Sharp.Warning,
                        contentDescription = Icons.Sharp.Warning.name,
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                    SmallSpacer()
                    Title(
                        text = R.string.info_button_rules,
                        color = MaterialTheme.colorScheme.onSecondary
                    )
                }
            }
            SmallSpacer()
            Card(
                modifier = Modifier.weight(1f),
                click = { navController?.navigate(Info) },
                backgroundColor = MaterialTheme.colorScheme.errorContainer
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Sharp.Info, contentDescription = Icons.Sharp.Info.name)
                    SmallSpacer()
                    Title(
                        text = R.string.info_button_about_us,
                        color = MaterialTheme.colorScheme.onErrorContainer
                    )
                }
            }
        }
        SmallSpacer()
        Card(
            modifier = Modifier.fillMaxWidth(),
            click = { navController?.navigate(Settings) },
            backgroundColor = MaterialTheme.colorScheme.tertiaryContainer
        ){
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(imageVector = Icons.Sharp.Settings, contentDescription = Icons.Sharp.Settings.name)
                SmallSpacer()
                Title(
                    text = R.string.info_button_settings,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }
    }
}

@Composable
private fun Card(
    modifier: Modifier = Modifier,
    click: () -> Unit = {},
    backgroundColor: Color = Color.Transparent,
    content: @Composable () -> Unit = {}
) {
    EmptyCard(
        modifier = modifier.height(CardHeight.dp),
        circleShape = true,
        click = { click.invoke() }) {
        Box(
            modifier = Modifier
                .background(backgroundColor)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            content.invoke()
        }
    }
}

@Preview(showBackground = true, showSystemUi = false)
@Preview(showBackground = true, showSystemUi = false, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LinkSectionPreview() {
    Theme_100DOC {
        Surface {
            LinkSection()
        }
    }
}
