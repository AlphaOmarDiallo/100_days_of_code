package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EventCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumCategoryButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallBodyTextString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.colorGold
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.smallPadding
import timber.log.Timber

@Composable
fun ProgressSection(
    challenges: List<Challenge?> = emptyList(),
    user: User? = null,
    addChallenge: () -> Unit? = {},
    startAction: () -> Unit? = {}
) {
    val currentChallenge = challenges.filterNotNull().find { !it.isCompleted }

    if (user == null) {
        NoUserNoChallenge(startAction = startAction)
    } else {
        if (currentChallenge != null) {
            challenges.mapNotNull { it?.isCompleted }
            OnGoingChallenge(challenge = currentChallenge)
        } else {
            AllChallengesCompleted(
                challenges = challenges.filterNotNull(),
            ) {
                addChallenge.invoke()
            }
        }
    }
}

@Composable
private fun NoUserNoChallenge(startAction: () -> Unit? = {}) {
    EventCard(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(smallPadding()),
        cardHeight = 170.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(mediumPadding())
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(smallPadding())
            ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    Box(modifier = Modifier.padding(smallPadding())) {
                        Box(modifier = Modifier.size(140.dp), contentAlignment = Alignment.Center) {
                            LottieWithCoilPlaceholder(
                                size = 140.dp,
                                lottieJson = R.raw.rocket_animation
                            )
                        }
                    }
                    Column(
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(1f),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        MediumCategoryButton(
                            label = R.string.dashboard_my_progress_start,
                            icon = R.drawable.ic_launcher_foreground
                        ) {
                            startAction.invoke()
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun OnGoingChallenge(challenge: Challenge?) {
    EventCard(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(
                smallPadding()
            ),
        click = { Timber.d("My progress card clicked") }
    ) {
        val targetProgress = (challenge?.currentProgress?.toFloat()?.div(100)) ?: 0f
        val animatedProgress by animateFloatAsState(
            targetValue = targetProgress,
            animationSpec = tween(durationMillis = 1000),
            label = "Progress animation"
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(mediumPadding()),
            verticalArrangement = Arrangement.Center
        ) {
            Title(text = R.string.dashboard_my_progress_title)
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    SmallTitle(text = R.string.dashboard_my_progress_goal)
                    MediumSpacer()
                    SmallBodyTextString(text = challenge?.declarationOfIntention ?: "")
                    MediumSpacer()
                    SmallTitleString(
                        text = String.format(
                            stringResource(id = R.string.dashboard_my_progress_percentage),
                            challenge?.currentProgress ?: 0
                        )
                    )
                }

                Box(modifier = Modifier.padding(smallPadding())) {
                    Box(modifier = Modifier.size(130.dp), contentAlignment = Alignment.Center) {
                        LottieWithCoilPlaceholder(
                            size = 140.dp,
                            lottieJson = R.raw.coding
                        )
                        CircularProgressIndicator(
                            progress = { animatedProgress },
                            modifier = Modifier.size(130.dp),
                            color = colorGold,
                            strokeWidth = 10.dp,
                            strokeCap = StrokeCap.Butt,
                            gapSize = 2.dp
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AllChallengesCompleted(
    challenges: List<Challenge> = emptyList(),
    startAction: () -> Unit? = {}
) {
    EventCard(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.tertiaryContainer)
            .padding(
                smallPadding()
            ),
        click = { Timber.d("My progress card clicked") }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(mediumPadding()),
            verticalArrangement = Arrangement.Center
        ) {
            Title(text = R.string.dashboard_subtitle_all_challenges_done)
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    MediumSpacer()

                    val progressText = String.format(
                        LocalContext.current.resources.getQuantityText(
                            R.plurals.dashboard_my_progress_challenges_completed,
                            challenges.size
                        ).toString(), challenges.size, (challenges.size * 100)
                    )

                    SmallTitleString(text = progressText)
                    LottieWithCoilPlaceholder(
                        size = 80.dp,
                        lottieJson = R.raw.plant_growing
                    )
                }
                SmallSpacer()
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    MediumCategoryButton(
                        label = R.string.dashboard_my_progress_start,
                        icon = R.drawable.ic_launcher_foreground
                    ) {
                        startAction.invoke()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingPreview() {
    Theme_100DOC {
        Surface {
            Column(
                modifier = Modifier
                    .padding(largePadding())
                    .fillMaxSize()
            ) {
                ProgressSection(
                    challenges = emptyList(),
                    user = null
                )
                largePadding()
                ProgressSection(
                    challenges = listOf(
                        Challenge(
                            declarationOfIntention = "Exploring the world of Android development, building apps that bring ideas to life.",
                            currentProgress = 51,
                            startDate = null,
                            endDate = null,
                            isCompleted = false,
                            entries = emptyList()
                        )
                    ),
                    user = User(name = "Alpha")
                )
                largePadding()
                ProgressSection(
                    challenges = emptyList(),
                    user = User(name = "Alpha")
                )
            }
        }
    }
}
