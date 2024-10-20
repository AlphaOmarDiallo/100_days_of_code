package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import _100_days_of_codeTheme
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun OnBoardingScreen(viewmodel: OnBoardingViewModel = koinViewModel(), onClose: () -> Unit) {
    OnBoardingContent(onClose = onClose) { name, intention, startFrom, startDate ->
        viewmodel.createNewUserAndChallenge(name, intention, startFrom, startDate)
    }
}

@Composable
fun OnBoardingContent(
    onClose: () -> Unit = {},
    createUser: (str1: String, str2: String, int: Int, str3: String) -> Unit = { _, _, _, _ -> }
) {
    val pagerState = rememberPagerState(pageCount = { 2 })
    val coroutineScope = rememberCoroutineScope()
    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .fillMaxSize(),
            userScrollEnabled = false
        ) { page ->
            when (page) {
                0 -> CommitScreen {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(1)
                    }
                }

                1 -> StartScreen(
                    returnButtonAction = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(0)
                        }
                    }
                ) { name, intention, startFrom, startDate ->
                    if (name.isEmpty() || intention.isEmpty()) {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    } else {
                        Timber.d("name: $name, intention: $intention, startFrom: $startFrom")
                        createUser.invoke(name, intention, startFrom, startDate)
                        onClose.invoke()
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
        Surface {
            OnBoardingContent()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingDarkPreview() {
    _100_days_of_codeTheme {
        Surface {
            OnBoardingContent()
        }
    }
}
