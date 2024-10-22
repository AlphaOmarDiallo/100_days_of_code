package com.alphaomardiallo.a100_days_of_code.feature.info.presentation

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyTextString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LoaderGeneric
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallBodyTextString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.openLink
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.model.App
import org.koin.androidx.compose.koinViewModel

@Composable
fun InfoScreen(navController: NavController, viewModel: InfoViewModel = koinViewModel()) {
    val state = viewModel.uiState.collectAsStateWithLifecycle()
    InfoDialogContent(list = state.value.apps, navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InfoDialogContent(list: List<App> = emptyList(), navController: NavController? = null) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.padding(horizontal = largePadding()),
                        text = R.string.info_title
                    )
                },
                navigationIcon = {
                    SmallIconButton {
                        navController?.popBackStack()
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.error,
                    titleContentColor = MaterialTheme.colorScheme.onError,
                    navigationIconContentColor = MaterialTheme.colorScheme.onErrorContainer
                )
            )
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                BodyText(text = R.string.info_description)
            }

            item {
                MediumSpacer()
                val text = stringResource(id = R.string.info_my_website)
                SmallBodyTextString(
                    modifier = Modifier.clickable { openLink(context = context, url = text) },
                    text = text,
                    color = Color.Blue,
                )

            }

            if (list.isEmpty()) {
                item {
                    MediumSpacer()
                    Title(text = R.string.info_my_apps)
                }

                item {
                    MediumSpacer()
                    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                        LoaderGeneric()
                    }
                }
            }

            items(list) { app ->
                AppItem(app = app)
            }
        }
    }
}

@Composable
private fun AppItem(app: App) {
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { openLink(context = context, url = app.playStoreLink) }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(80.dp)
                    .padding(8.dp)
            ) {
                AsyncImage(model = app.imgResource, contentDescription = "")
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalArrangement = Arrangement.Center
            ) {
                SmallTitleString(text = app.name)
                BodyTextString(text = app.description)
            }
        }
    }
}


@Composable
private fun InfoDialogContentPreview() {
    InfoDialogContent()
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingPreview() {
    Theme_100DOC {
        Surface {
            InfoDialogContentPreview()
        }
    }
}
