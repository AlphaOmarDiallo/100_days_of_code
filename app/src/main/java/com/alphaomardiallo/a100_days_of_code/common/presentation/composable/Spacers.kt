package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SmallSpacer() {
    Spacer(modifier = Modifier.padding(4.dp))
}

@Composable
fun MediumSpacer() {
    Spacer(modifier = Modifier.padding(8.dp))
}

@Composable
fun LargeSpacer() {
    Spacer(modifier = Modifier.padding(16.dp))
}
