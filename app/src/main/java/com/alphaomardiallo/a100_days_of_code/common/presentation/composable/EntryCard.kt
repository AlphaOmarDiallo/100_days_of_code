package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.longToFormattedDate

@Composable
fun EntryCard(modifier: Modifier = Modifier, entry: Entry, click: () -> Unit) {
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
                            stringResource(id = R.string.entry_card_mood),
                            entry.mood
                        )
                    )
                    SmallSpacer()
                    SmallTitleString(text = longToFormattedDate(entry.date))
                }

                SmallIconButton(icon = R.drawable.sharp_share_24){
                    click.invoke()
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun EntryCardPreview() {
    _100_days_of_codeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                EntryCard(
                    entry = Entry(
                        title = "Day 1: Let's start",
                        content = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec turpis nunc, tempus quis elit quis, sodales euismod ante. Proin sed erat interdum, egestas diam non, aliquet leo. Morbi venenatis urna et libero vestibulum semper. Duis commodo nunc ac nisl volutpat lobortis. Nullam ornare elit sed justo elementum, eu pellentesque sapien malesuada. Nulla eu rutrum mi. Cras consectetur porta augue ut posuere. Donec ut consequat leo. "
                    )
                ){}
            }
        }
    }
}
