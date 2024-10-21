package com.alphaomardiallo.a100_days_of_code.common.presentation.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.alphaomardiallo.a100_days_of_code.R

@Composable
fun LoaderGeneric() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        LottieWithCoilPlaceholder()
        LargeTitle(text = R.string.loader)
    }
}
