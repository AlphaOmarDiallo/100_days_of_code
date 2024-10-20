package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable

import _100_days_of_codeTheme
import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EntryCard

@Composable
fun LatestEntry(entry: Entry, click: () -> Unit = {}){
    EntryCard(entry = entry) {
        click.invoke()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LatestEntryPreview() {
    _100_days_of_codeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                LatestEntry(entry = Entry())
            }
        }
    }
}