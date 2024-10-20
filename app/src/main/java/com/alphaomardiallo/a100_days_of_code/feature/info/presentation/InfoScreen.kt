package com.alphaomardiallo.a100_days_of_code.feature.info.presentation

import _100_days_of_codeTheme
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.alphaomardiallo.a100_days_of_code.R
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
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.info_title),
                        modifier = Modifier.padding(8.dp),
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = Icons.Default.Clear.name,
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                navController?.popBackStack()
                            }
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.onTertiary,
                    navigationIconContentColor = MaterialTheme.colorScheme.onTertiary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .padding(innerPadding)
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.info_description),
                    modifier = Modifier.padding(8.dp),
                    textAlign = TextAlign.Justify
                )
            }

            item {
                val text = stringResource(id = R.string.info_my_website)
                Text(
                    text = text,
                    modifier = Modifier
                        .padding(8.dp)
                        .clickable {
                            openLink(context = context, url = text)
                        },
                    textAlign = TextAlign.Justify,
                    textDecoration = TextDecoration.Underline,
                    color = Color.Blue
                )
            }

            item {
                Text(
                    text = stringResource(id = R.string.info_my_apps),
                    modifier = Modifier.padding(8.dp),
                    style = MaterialTheme.typography.titleMedium
                )
            }

            if (list.isEmpty()) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        CircularProgressIndicator(modifier = Modifier.size(100.dp))
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
                Text(
                    text = app.name,
                    style = MaterialTheme.typography.titleSmall,
                    modifier = Modifier.padding(8.dp)
                )
                Text(text = app.description, modifier = Modifier.padding(horizontal = 8.dp))
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
    _100_days_of_codeTheme {
        Surface {
            InfoDialogContentPreview()
        }
    }
}
