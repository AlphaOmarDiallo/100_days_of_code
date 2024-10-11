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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSensitiveActionButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding

@Composable
private fun getTextColor() = MaterialTheme.colorScheme.onPrimaryContainer

@Composable
fun CommitScreen(
    commitButtonAction: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(largePadding())
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            LargeTitle(
                modifier = Modifier.fillMaxWidth(),
                text = R.string.app_name_short,
                align = TextAlign.Center,
                color = getTextColor()
            )
            MediumSpacer()
            Row(verticalAlignment = Alignment.CenterVertically){
                LottieWithCoilPlaceholder(size = 50.dp)

                BodyText(
                    modifier = Modifier.fillMaxWidth(),
                    text = R.string.onboarding_commit_subtitle,
                    align = TextAlign.Justify,
                    color = getTextColor()
                )
            }
            MediumSpacer()
        }
        Column {
            Title(text = R.string.onboarding_commit_rules_title)
            MediumSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_1,
                align = TextAlign.Justify,
                color = getTextColor()
            )
            SmallSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_2,
                align = TextAlign.Justify,
                color = getTextColor()
            )
            SmallSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_3,
                align = TextAlign.Justify,
                color = getTextColor()
            )
            SmallSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_4,
                align = TextAlign.Justify,
                color = getTextColor()
            )
            SmallSpacer()
        }

        LargeSensitiveActionButton(
            text = R.string.onboarding_commit_button_commit,
            icon = R.drawable.sharp_code_24
        ) {
            commitButtonAction.invoke()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    _100_days_of_codeTheme {
        CommitScreen()
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingDarkPreview() {
    _100_days_of_codeTheme {
        CommitScreen()
    }
}
