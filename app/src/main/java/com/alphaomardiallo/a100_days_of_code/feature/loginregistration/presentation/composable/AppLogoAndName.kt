package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R

@Preview
@Composable
fun AppLogoAndName() {
    Box(
        modifier = Modifier
            .fillMaxHeight(0.2f),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier.fillMaxHeight(),
            shape = RoundedCornerShape(8.dp),
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_100_doc),
                contentDescription = stringResource(id = R.string.app_logo_description),
                modifier = Modifier.fillMaxHeight()
            )
        }
    }
}
