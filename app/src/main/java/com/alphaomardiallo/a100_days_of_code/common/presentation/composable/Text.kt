package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding

@Composable
fun LargeTitle(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = color,
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun LargeTitleString(
    modifier: Modifier = Modifier,
    text: String = "",
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge.copy(
            color = color,
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun SmallTitle(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun SmallTitleString(
    modifier: Modifier = Modifier,
    text: String = "",
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold,
            color = color
        )
    )
}

@Composable
fun SmallTitleClickable(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground,
    content: () -> Unit = {}
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier.clickable { content.invoke() },
        style = MaterialTheme.typography.bodySmall.copy(
            textAlign = align,
            fontWeight = FontWeight.W600,
            textDecoration = TextDecoration.Underline,
            color = color
        )
    )
}

@Composable
fun LargeBodyText(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyLarge.copy(textAlign = align, color = color),
        modifier = modifier
    )
}

@Composable
fun BodyText(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyMedium.copy(textAlign = align, color = color),
        modifier = modifier
    )
}

@Composable
fun BodyTextString(
    modifier: Modifier = Modifier,
    text: String = "",
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodyMedium.copy(textAlign = align, color = color),
        modifier = modifier
    )
}

@Composable
fun SmallBodyText(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodySmall.copy(textAlign = align, color = color),
        modifier = modifier
    )
}

@Composable
fun SmallBodyTextString(
    modifier: Modifier = Modifier,
    text: String = "",
    align: TextAlign = TextAlign.Left,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        text = text,
        style = MaterialTheme.typography.bodySmall.copy(textAlign = align, color = color),
        modifier = modifier
    )
}

@Composable
private fun PreviewContentPhone() {
    Theme_100DOC {
        Surface {
            Column(modifier = Modifier.padding(largePadding())) {
                LargeTitle()
                MediumSpacer()
                Title()
                MediumSpacer()
                SmallTitle()
                MediumSpacer()
                SmallTitleClickable()
                MediumSpacer()
                LargeBodyText()
                MediumSpacer()
                BodyText()
                MediumSpacer()
                SmallBodyText()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TextPreviews() {
    Surface {
        PreviewContentPhone()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextPreviewsDark() {
    Surface {
        PreviewContentPhone()
    }
}
