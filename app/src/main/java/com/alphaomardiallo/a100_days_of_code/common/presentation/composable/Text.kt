package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding

@Composable
fun LargeTitle(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodyLarge.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun Title(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodyMedium.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun SmallTitle(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier,
        style = MaterialTheme.typography.bodySmall.copy(
            textAlign = align,
            fontWeight = FontWeight.Bold
        )
    )
}

@Composable
fun SmallTitleClickable(
    modifier: Modifier = Modifier,
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left,
    content: () -> Unit = {}
) {
    Text(
        text = stringResource(id = text),
        modifier = modifier.clickable { content.invoke() },
        style = MaterialTheme.typography.bodySmall.copy(
            textAlign = align,
            fontWeight = FontWeight.W600,
            textDecoration = TextDecoration.Underline
        )
    )
}

@Composable
fun LargeBodyText(
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyLarge.copy(textAlign = align)
    )
}

@Composable
fun BodyText(
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodyMedium.copy(textAlign = align)
    )
}

@Composable
fun SmallBodyText(
    text: Int = R.string.app_name,
    align: TextAlign = TextAlign.Left
) {
    Text(
        text = stringResource(id = text),
        style = MaterialTheme.typography.bodySmall.copy(textAlign = align)
    )
}

@Composable
private fun PreviewContentPhone() {
    _100_days_of_codeTheme {
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
    PreviewContentPhone()
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun TextPreviewsDark() {
    PreviewContentPhone()
}
