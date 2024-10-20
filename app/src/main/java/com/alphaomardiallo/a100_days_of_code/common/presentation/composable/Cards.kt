package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.smallPadding

@Composable
fun EmptyCard(
    modifier: Modifier = Modifier,
    circleShape: Boolean = false,
    click: () -> Unit = {},
    content: @Composable () -> Unit = {}
) {
    Card(
        onClick = { click.invoke() },
        modifier = modifier,
        shape = if (circleShape) RoundedCornerShape(50.dp) else RoundedCornerShape(10.dp),
        border = BorderStroke(0.5.dp, if (isSystemInDarkTheme()) Color.White else Color.Black)
    ) {
        content.invoke()
    }
}

@Composable
fun EventCard(
    modifier: Modifier = Modifier,
    click: () -> Unit = {},
    cardHeight: Dp = 200.dp,
    content: @Composable () -> Unit = {}
) {
    EmptyCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(cardHeight)
    ) {
        EmptyCard(
            modifier = modifier
                .fillMaxSize()
                .padding(smallPadding())
                .clickable { click.invoke() }
                .background(MaterialTheme.colorScheme.tertiaryContainer)
        ) {
            content.invoke()
        }
    }
}

@Composable
private fun PreviewContentPhone() {
    _100_days_of_codeTheme {
        Surface {
            Column(modifier = Modifier.padding(largePadding())) {
                EmptyCard(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                ) {
                    Text(text = "Text")
                }
                MediumSpacer()
                EventCard()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewsCards() {
    Surface {
        PreviewContentPhone()
    }
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun PreviewsCardsNight() {
    Surface {
        PreviewContentPhone()
    }
}
