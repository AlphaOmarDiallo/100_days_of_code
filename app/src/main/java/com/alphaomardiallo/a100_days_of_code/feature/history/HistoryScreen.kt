package com.alphaomardiallo.a100_days_of_code.feature.history

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.alphaomardiallo.a100_days_of_code.R

@Composable
fun HistoryScreen() {
    Text(text = stringResource(id = R.string.bottom_nav_route_history))
}