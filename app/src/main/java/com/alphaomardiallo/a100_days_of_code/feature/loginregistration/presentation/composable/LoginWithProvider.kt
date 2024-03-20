package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.presentation.composable

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.util.provideListOfProviders
import kotlin.reflect.KFunction1

@Composable
fun LoginWithProvider(
    isLogin: Boolean = true,
    signInWithProvider: KFunction1<Activity, Unit>? = null,
    activity: Activity?,
) {
    Column(
        modifier = Modifier.fillMaxWidth(0.9f),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = stringResource(id = R.string.login_provider_support_text),
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.padding(8.dp)
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            provideListOfProviders().forEach { provider ->
                ProviderBox(
                    link = provider.imageLink,
                    description = provider.imageDescription,
                    providerName = if (isLogin) provider.login else provider.register,
                    signIn = signInWithProvider,
                    activity = activity,
                    backGroundColor = provider.backGroundColor
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }
}

@Preview
@Composable
private fun ProviderBox(
    link: Int = 0,
    description: Int = 0,
    providerName: Int = 0,
    signIn: KFunction1<Activity, Unit>? = null,
    activity: Activity? = null,
    backGroundColor: Color = Color.Transparent,
) {

    Card(
        modifier = Modifier
            .height(60.dp)
            .fillMaxWidth()
            .clickable { activity?.let { signIn?.invoke(it) } },
        colors = CardDefaults.cardColors(containerColor = backGroundColor),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 8.dp,
            pressedElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                model = stringResource(id = link),
                contentDescription = stringResource(id = description),
                modifier = Modifier.fillMaxHeight()
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text(
                text = stringResource(id = providerName),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}