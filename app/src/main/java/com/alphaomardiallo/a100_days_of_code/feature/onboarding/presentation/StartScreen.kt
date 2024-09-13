package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSensitiveActionButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MultiLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SingleLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallBodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import timber.log.Timber

@Composable
private fun getTextColor() = MaterialTheme.colorScheme.onPrimaryContainer

@Composable
fun StartScreen(
    returnButtonAction: () -> Unit = {},
    startButtonAction: () -> Unit = {}
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(largePadding())
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        LargeTitle(
            modifier = Modifier.fillMaxWidth(),
            text = R.string.onboarding_start_title,
            align = TextAlign.Center,
            color = getTextColor()
        )
        MediumSpacer()

        SmallTitle(text = R.string.onboarding_start_name_question)
        SmallBodyText(text = R.string.onboarding_start_name_sub_question, align = TextAlign.Justify)
        SmallSpacer()
        SingleLineTextFields{
            Timber.e("SingleLineTextFields: $it")
        }
        MediumSpacer()

        SmallTitle(text = R.string.onboarding_start_intention_question)
        SmallBodyText(text = R.string.onboarding_start_intention_sub_question, align = TextAlign.Justify)
        SmallSpacer()
        MultiLineTextFields{
            Timber.e("MultiLineTextFields: $it")
        }
        SmallSpacer()

        LottieWithCoilPlaceholder(
            iterateForever = false,
            lottieJson = R.raw.plant_growing
        )
        SmallSpacer()

        Row {
            SmallIconButton(modifier = Modifier.padding(end = largePadding())){
                returnButtonAction.invoke()
            }
            LargeSensitiveActionButton(
                text = R.string.onboarding_commit_button_commit,
                icon = R.drawable.sharp_code_24
            ) {
                startButtonAction.invoke()
            }
        }
    }
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
