package com.alphaomardiallo.a100_days_of_code.feature.learn.presentation

import _100_days_of_codeTheme
import android.content.Context
import android.content.res.Configuration
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.BodyTextString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LoaderGeneric
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.mediumPadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.openLink
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.model.LearnItem
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LearningScreen(
    navController: NavController? = null,
    viewModel: LearningViewModel = koinViewModel()
) {
    val state = viewModel.uiState.collectAsState()
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.padding(horizontal = largePadding()),
                        text = R.string.add_entry_title
                    )
                },
                navigationIcon = {
                    SmallIconButton {
                        navController?.popBackStack()
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary,
                )
            )
        },
    ) { paddingValues ->
        LearningScreenContent(paddingValues = paddingValues, list = state.value.resources)
    }
}

@Composable
private fun LearningScreenContent(
    paddingValues: PaddingValues = PaddingValues(),
    list: List<LearnItem> = emptyList()
) {
    val context = LocalContext.current

    if (list.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            LoaderGeneric()
        }
    } else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(list) { learningItem ->
                LearningItemCard(context = context, learnItem = learningItem)
            }
        }
    }
}

@Composable
private fun LearningItemCard(context: Context? = null, learnItem: LearnItem = LearnItem()) {
    EmptyCard(
        modifier = Modifier.padding(mediumPadding()),
        click = { context?.let { openLink(it, learnItem.url) } }
    ) {
        Column(
            modifier = Modifier
                .padding(mediumPadding())
                .fillMaxWidth()
        ) {
            LargeTitleString(text = learnItem.name)
            SmallSpacer()
            BodyTextString(text = learnItem.shortDescription)
            SmallSpacer()
            SmallTitleString(text = learnItem.type)
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LearningSectionPreview() {
    _100_days_of_codeTheme {
        Surface {
            LearningScreenContent()
        }
    }
}
