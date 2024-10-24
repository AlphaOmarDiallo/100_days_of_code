package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC

@Composable
fun SingleLineTextFields(
    modifier: Modifier = Modifier,
    textValue: TextFieldValue = TextFieldValue(""),
    onTextChange: (TextFieldValue) -> Unit = {}
) {
    OutlinedTextField(
        value = textValue,
        onValueChange = { newText ->
            onTextChange(newText.copy(selection = TextRange(newText.text.length)))
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
    Theme_100DOC {
        Column {
            SingleLineTextFields()
            LargeSpacer()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun TextFieldsPreview() {
    Surface {
        PreviewContent()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextFieldsDarkPreview() {
    Surface {
        PreviewContent()
    }
}
