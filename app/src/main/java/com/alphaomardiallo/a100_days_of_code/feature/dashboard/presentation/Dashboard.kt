package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Dashboard(paddingValues: PaddingValues){
    Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
        Text(text = "Dashboard")
    }
}
