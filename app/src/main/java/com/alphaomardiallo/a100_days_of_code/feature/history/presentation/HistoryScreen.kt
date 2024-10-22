package com.alphaomardiallo.a100_days_of_code.feature.history.presentation

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyTextString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EntryCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.longToFormattedDate
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@Composable
fun HistoryScreen(
    navController: NavController? = null,
    viewModel: HistoryViewModel = koinViewModel()
) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    HistoryScreenContent(
        challenges = state.value.challenges,
        returnAction = { navController?.popBackStack() },
        deleteAction = viewModel::deleteEntry
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryScreenContent(
    challenges: List<Challenge> = emptyList(),
    returnAction: () -> Unit = {},
    deleteAction: (Long, Entry) -> Unit = { _, _ -> }
) {
    val pagerState = rememberPagerState(pageCount = { challenges.size })
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.padding(horizontal = largePadding()),
                        text = R.string.history_title
                    )
                },
                navigationIcon = {
                    SmallIconButton {
                        returnAction.invoke()
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.secondaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onSecondaryContainer,
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(largePadding()),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                challenges.forEachIndexed { index, _ ->
                    Column(
                        modifier = Modifier
                            .width(20.dp)
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(index)
                                }
                            },
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        BodyTextString(
                            text = (index + 1).toString(),
                            color =
                            if (pagerState.currentPage == index) MaterialTheme.colorScheme.primary
                            else MaterialTheme.colorScheme.onSurface
                        )
                        if (pagerState.currentPage == index) {
                            HorizontalDivider(
                                thickness = 2.dp,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        if (challenges.isEmpty()) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    LargeTitle(text = R.string.history_empty, align = TextAlign.Center)
                    LargeSpacer()
                    LottieWithCoilPlaceholder()
                }
            }
        } else {
            LaunchedEffect(key1 = challenges) {
                pagerState.scrollToPage(challenges.size - 1)
            }

            HorizontalPager(
                state = pagerState,
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(largePadding())
                    .fillMaxSize()
            ) {
                val challenge = challenges[pagerState.currentPage]
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    item {
                        Title(
                            modifier = Modifier.padding(horizontal = largePadding()),
                            text = R.string.history_subtitle
                        )
                        SmallSpacer()
                        BodyTextString(
                            modifier = Modifier.padding(horizontal = largePadding()),
                            text = challenge.declarationOfIntention
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(largePadding()),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            challenge.startDate?.let {
                                BodyTextString(text = longToFormattedDate(it))
                            }
                            challenge.endDate?.let {
                                BodyTextString(text = longToFormattedDate(it))
                            }
                        }
                    }

                    val sortedEntries = challenge.entries.sortedByDescending { it.number }

                    items(sortedEntries) { entry ->
                        val isLastItem = entry == sortedEntries.first()

                        EntryCard(entry = entry, listMode = isLastItem && !challenge.isCompleted) {
                            Timber.d("Delete entry ${entry.number}")
                            deleteAction.invoke(challenge.id, entry)
                        }
                        SmallSpacer()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun HistoryScreenPreview() {
    Theme_100DOC {
        Surface {
            HistoryScreenContent()
        }
    }
}
