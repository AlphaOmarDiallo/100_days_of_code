package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallBodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.smallPadding
import com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.model.StatItem

@Composable
fun StatSection(list: List<StatItem> = emptyList()) {
    if (list.isNotEmpty() && list.any { it.stat != 0 }){
        Column {
            Title(text = R.string.dashboard_stat_title)
            SmallSpacer()
            EmptyCard(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.tertiaryContainer),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    list.filter { it.stat != 0 }.forEach {
                        StatItemView(modifier = Modifier.weight(1f), stat = it.stat, label = it.label)
                    }
                }
            }
        }
    }
}

@Composable
private fun StatItemView(modifier: Modifier, stat: Int, label: Int) {
    Column(
        modifier = modifier.padding(smallPadding()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LargeTitleString(
            text = stat.toString(),
            color = MaterialTheme.colorScheme.onTertiaryContainer
        )
        mediumPadding()
        SmallBodyText(text = label, color = MaterialTheme.colorScheme.onTertiaryContainer)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingPreview() {
    _100_days_of_codeTheme {
        Surface {
            Column(
                modifier = Modifier
                    .padding(largePadding())
                    .fillMaxSize()
            ) {
                StatSection()
            }
        }
    }
}
