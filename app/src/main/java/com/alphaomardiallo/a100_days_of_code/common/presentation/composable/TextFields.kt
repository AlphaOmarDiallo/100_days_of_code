package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SingleLineTextFields(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onTextChange(newText)
        },
        modifier = modifier.fillMaxWidth(),
        singleLine = true
    )
}

@Composable
fun MultiLineTextFields(
    modifier: Modifier = Modifier,
    onTextChange: (String) -> Unit = {}
) {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { newText ->
            text = newText
            onTextChange(newText)
        },
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp),
        singleLine = false
    )
}

@Composable
private fun PreviewContent() {
    _100_days_of_codeTheme {
        Column {
            SingleLineTextFields()
            LargeSpacer()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TextFieldsPreview() {
    PreviewContent()
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextFieldsDarkPreview() {
    PreviewContent()
}
