package com.alphaomardiallo.a100_days_of_code.feature.rules.presentation

import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.openLink

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RulesScreen(navController: NavController? = null) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.padding(horizontal = largePadding()),
                        text = R.string.rules_title
                    )
                },
                navigationIcon = {
                    SmallIconButton {
                        navController?.popBackStack()
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondary,
                    titleContentColor = MaterialTheme.colorScheme.onSecondary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onSecondary
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
                .padding(largePadding())
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                LottieWithCoilPlaceholder(lottieJson = R.raw.warning, size = 100.dp)
            }
            LargeSpacer()
            LargeTitle(text = R.string.onboarding_commit_rules_title)
            MediumSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_1,
                align = TextAlign.Justify,
            )
            MediumSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_2,
                align = TextAlign.Justify,
            )
            MediumSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_3,
                align = TextAlign.Justify,
            )
            MediumSpacer()
            BodyText(
                text = R.string.onboarding_commit_rules_4,
                align = TextAlign.Justify,
            )
            MediumSpacer()
            Title(text = R.string.onboarding_commit_rules_5)
            MediumSpacer()
            BodyText(
                modifier = Modifier.clickable {
                    openLink(
                        context,
                        "https://www.100daysofcode.com"
                    )
                },
                text = R.string.rules_website,
                align = TextAlign.Justify,
                color = Color.Blue
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun RulesPreview() {
    Theme_100DOC {
        Surface {
            RulesScreen()
        }
    }
}
