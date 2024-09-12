package com.alphaomardiallo.a100_days_of_code.feature.firststart.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FirstStart(paddingValues: PaddingValues){
    Column(modifier = Modifier.padding(paddingValues).fillMaxSize()) {
        Text(text = "Welcome to 100 Days of Code")
    }
}
