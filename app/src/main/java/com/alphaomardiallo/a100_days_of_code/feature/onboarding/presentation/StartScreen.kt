package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun StartScreen(
    returnButtonAction: () -> Unit = {}
) {
    Text(text = "Commit", modifier = Modifier.clickable { returnButtonAction.invoke() })
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    _100_days_of_codeTheme {
        StartScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingDarkPreview() {
    _100_days_of_codeTheme {
        StartScreen()
    }
}
