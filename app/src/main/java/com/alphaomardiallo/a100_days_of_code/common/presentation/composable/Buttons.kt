package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding

private val SMALL_BUTTON_SIZE = 40.dp
private val MEDIUM_BUTTON_SIZE = 60.dp

@Composable
fun SmallIconButton(
    modifier: Modifier = Modifier,
    text: Int? = null,
    icon: Int? = R.drawable.sharp_arrow_back_24,
    iconColorUnspecified: Boolean = false,
    contentDescription: Int = R.string.app_name,
    containerColor: Color = MaterialTheme.colorScheme.primaryContainer,
    contentColor: Color = MaterialTheme.colorScheme.onPrimaryContainer,
    containerHeight: Dp = SMALL_BUTTON_SIZE,
    containerWidth: Dp = SMALL_BUTTON_SIZE,
    containerCornerShape: Dp = mediumPadding(),
    enabled: Boolean = true,
    click: () -> Unit = {}
) {
    Card(
        onClick = { click.invoke() },
        modifier = modifier
            .width(containerHeight)
            .height(containerWidth),
        enabled = enabled,
        shape = RoundedCornerShape(containerCornerShape),
        border = BorderStroke(0.5.dp, if (isSystemInDarkTheme()) Color.White else Color.Black),
        colors = CardDefaults.cardColors().copy(
            containerColor = containerColor,
            contentColor = contentColor,
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            icon?.let {
                Icon(
                    painter = painterResource(id = icon),
                    contentDescription = stringResource(id = contentDescription),
                    tint = if (!iconColorUnspecified) LocalContentColor.current else Color.Unspecified
                )
            }
            text?.let {
                SmallSpacer()
                LargeBodyText(text = text, align = TextAlign.Center)
            }
        }
    }
}

@Composable
fun SmallIconButtonClose(
    icon: Int = R.drawable.sharp_close_24,
    click: () -> Unit = {}
) {
    SmallIconButton(
        icon = icon,
        containerColor = MaterialTheme.colorScheme.errorContainer,
        contentColor = MaterialTheme.colorScheme.onErrorContainer,
        click = click
    )
}

@Composable
fun MediumCategoryButton(
    label: Int = R.string.app_name,
    icon: Int = R.drawable.ic_launcher_foreground,
    click: () -> Unit = {}
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        SmallIconButton(
            icon = icon,
            containerHeight = MEDIUM_BUTTON_SIZE,
            containerWidth = MEDIUM_BUTTON_SIZE,
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            click = click
        )
        SmallSpacer()
        SmallBodyText(text = label, align = TextAlign.Center)
    }
}

@Composable
fun LargeProviderLoginButton(
    icon: Int? = R.drawable.ic_google,
    text: Int = R.string.app_name,
    click: () -> Unit = {}
) {
    icon?.let {
        SmallIconButton(
            modifier = Modifier.fillMaxWidth(),
            icon = icon,
            text = text,
            iconColorUnspecified = true,
            containerColor = MaterialTheme.colorScheme.surfaceContainer,
            contentColor = MaterialTheme.colorScheme.onSurface,
            click = click
        )
    }
}

@Composable
fun LargeActionButton(
    icon: Int? = null,
    text: Int = R.string.app_name,
    click: () -> Unit = {}
) {
    SmallIconButton(
        modifier = Modifier.fillMaxWidth(),
        icon = icon,
        text = text,
        click = click
    )
}

@Composable
fun LargeSensitiveActionButton(
    text: Int = R.string.app_name,
    icon: Int? = null,
    isEnabled: Boolean = true,
    click: () -> Unit = {},
) {
    SmallIconButton(
        modifier = Modifier.fillMaxWidth(),
        icon = icon,
        text = text,
        containerColor = MaterialTheme.colorScheme.errorContainer,
        contentColor = MaterialTheme.colorScheme.onErrorContainer,
        enabled = isEnabled,
        click = click
    )
}

@Composable
private fun PreviewContentPhone() {
    _100_days_of_codeTheme {
        Surface {
            Column(modifier = Modifier.padding(largePadding())) {
                SmallIconButton()
                MediumSpacer()
                SmallIconButtonClose()
                MediumSpacer()
                MediumSpacer()
                MediumCategoryButton()
                MediumSpacer()
                LargeProviderLoginButton()
                MediumSpacer()
                LargeActionButton()
                MediumSpacer()
                LargeActionButton(icon = R.drawable.ic_launcher_foreground)
                MediumSpacer()
                LargeSensitiveActionButton()
                MediumSpacer()
                LargeSensitiveActionButton(icon = R.drawable.ic_launcher_foreground)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewsButtons() {
    PreviewContentPhone()
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewsButtonsNight() {
    PreviewContentPhone()
}
