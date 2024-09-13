package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch


@Composable
fun OnBoarding(paddingValues: PaddingValues) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(paddingValues)
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> CommitScreen() {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                }

                1 -> StartScreen() {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(0)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun OnBoardingPreview() {
    _100_days_of_codeTheme {
        OnBoarding(PaddingValues())
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingDarkPreview() {
    _100_days_of_codeTheme {
        OnBoarding(PaddingValues())
    }
}
