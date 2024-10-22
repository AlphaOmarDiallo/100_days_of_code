package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.longToFormattedDate

@Composable
fun EntryCard(
    modifier: Modifier = Modifier,
    entry: Entry,
    listMode: Boolean = false,
    deleteAction: () -> Unit = {}
) {
    val context = LocalContext.current
    var shareItems by remember { mutableStateOf(false) }
    var showTwitter by remember { mutableStateOf(false) }
    var showInstagram by remember { mutableStateOf(false) }
    var showTikTok by remember { mutableStateOf(false) }

    LaunchedEffect(shareItems) {
        if (shareItems) {
            showTwitter = true
            showInstagram = true
            showTikTok = true
        } else {
            showTwitter = false
            showInstagram = false
            showTikTok = false
        }
    }

    EmptyCard(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(largePadding())
        ) {
            LargeTitleString(text = entry.title)
            SmallSpacer()
            SmallBodyTextString(text = entry.content)
            SmallSpacer()
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    SmallTitleString(
                        text = String.format(
                            stringResource(id = R.string.dashboard_entry_card_mood),
                            entry.mood
                        )
                    )
                    SmallSpacer()
                    SmallTitleString(text = longToFormattedDate(entry.date))
                }

                if (shareItems) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = mediumPadding())
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        // Animate TikTok icon
                        AnimatedVisibility(
                            visible = showTikTok,
                            enter = slideInHorizontally(
                                initialOffsetX = { it },
                                animationSpec = tween(durationMillis = 300)
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.tiktok_logo),
                                contentDescription = "Tiktok logo",
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        openTikTok(context)
                                        shareItems = !shareItems
                                    }
                            )
                        }
                        MediumSpacer()

                        // Animate Instagram icon
                        AnimatedVisibility(
                            visible = showInstagram,
                            enter = slideInHorizontally(
                                initialOffsetX = { it }, // Slide in from the left
                                animationSpec = tween(durationMillis = 300)
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.insta_logo),
                                contentDescription = "Instagram logo",
                                modifier = Modifier
                                    .size(22.dp)
                                    .clickable {
                                        openInstagram(context)
                                        shareItems = !shareItems
                                    }
                            )
                        }
                        MediumSpacer()

                        // Animate Twitter icon
                        AnimatedVisibility(
                            visible = showTwitter,
                            enter = slideInHorizontally(
                                initialOffsetX = { it }, // Slide in from the left
                                animationSpec = tween(durationMillis = 300)
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.twitter_logo),
                                contentDescription = "Twitter logo",
                                modifier = Modifier
                                    .size(18.dp)
                                    .clickable {
                                        shareTextToTwitter(
                                            context = context,
                                            text = "Day${entry.number} - ${entry.content} #100DaysOfCode"
                                        )
                                        shareItems = !shareItems
                                    }
                            )
                        }
                        MediumSpacer()
                    }
                }
                Row {
                    SmallIconButton(icon = R.drawable.sharp_share_24) {
                        shareItems = !shareItems
                    }
                    if (listMode) {
                        SmallSpacer()
                        SmallIconButtonClose(icon = R.drawable.sharp_delete_forever_24) {
                            deleteAction.invoke()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EntryCardPreview() {
    Theme_100DOC {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                EntryCard(
                    listMode = true,
                    entry = Entry(
                        title = "Day 1: Let's start",
                        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis nunc, tempus quis elit quis, sodales euismod ante. Proin sed erat interdum, egestas diam non, aliquet leo. Morbi venenatis urna et libero vestibulum semper. Duis commodo nunc ac nisl volutpat lobortis. Nullam ornare elit sed justo elementum, eu pellentesque sapien malesuada. Nulla eu rutrum mi. Cras consectetur porta augue ut posuere. Donec ut consequat leo. "
                    )
                )
            }
        }
    }
}

private fun shareTextToTwitter(context: Context, text: String) {
    val tweetUrl = "https://twitter.com/intent/tweet?text=${Uri.encode(text)}"
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl))

    try {
        if (intent.resolveActivity(context.packageManager) != null) {
            context.startActivity(intent)
        } else {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tweetUrl))
            context.startActivity(browserIntent)
        }
    } catch (e: Exception) {
        Toast.makeText(context, "Error sharing to Twitter", Toast.LENGTH_SHORT).show()
    }
}

private fun openInstagram(context: Context) {
    val instagramPackage = "com.instagram.android"
    val instagramUrl = "https://www.instagram.com"

    val intent = context.packageManager.getLaunchIntentForPackage(instagramPackage)

    try {
        if (intent != null) {
            context.startActivity(intent)
        } else {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(instagramUrl))
            context.startActivity(browserIntent)
        }
    } catch (e: Exception) {
        Toast.makeText(context, "Error opening Instagram", Toast.LENGTH_SHORT).show()
    }
}

private fun openTikTok(context: Context) {
    val tiktokPackage = "com.zhiliaoapp.musically"
    val tiktokUrl = "https://www.tiktok.com"

    // Create an intent to open TikTok app
    val intent = context.packageManager.getLaunchIntentForPackage(tiktokPackage)

    try {
        if (intent != null) {
            // TikTok app is installed, open it
            context.startActivity(intent)
        } else {
            // TikTok app is not installed, open the web version
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tiktokUrl))
            context.startActivity(browserIntent)
        }
    } catch (e: Exception) {
        Toast.makeText(context, "Error opening TikTok", Toast.LENGTH_SHORT).show()
    }
}
