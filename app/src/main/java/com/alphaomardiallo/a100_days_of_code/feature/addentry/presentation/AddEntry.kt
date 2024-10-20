package com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation

import _100_days_of_codeTheme
import android.app.DatePickerDialog
import android.content.res.Configuration
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BasicAlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.EmptyCard
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeActionButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MultiLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SingleLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import org.koin.androidx.compose.koinViewModel
import java.util.Calendar

@Composable
fun AddEntryScreen(
    navController: NavController,
    viewModel: AddEntryViewModel = koinViewModel(),
    progress: Int = 0
) {
    AddEntryScreenContent(
        navController = navController,
        saveData = viewModel::addEntry,
        challengeProgress = progress
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AddEntryScreenContent(
    navController: NavController? = null,
    saveData: (String, String, Float, String) -> Unit = { _, _, _, _ -> },
    challengeProgress: Int = 0
) {
    val context = LocalContext.current
    var titleValue by remember { mutableStateOf("Day ${challengeProgress + 1}") }
    var descriptionValue by remember { mutableStateOf("") }
    var sliderValue by remember { mutableFloatStateOf(3f) }
    var showEndChallengeDialog by remember { mutableStateOf(false) }

    var showDatePicker by remember { mutableStateOf(false) }
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    var selectedDate by remember { mutableStateOf("$day/${month + 1}/$year") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { LargeTitle(modifier = Modifier.padding(horizontal = largePadding()), text = R.string.add_entry_title) },
                navigationIcon = {
                    SmallIconButton {
                        navController?.popBackStack()
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    titleContentColor = MaterialTheme.colorScheme.onTertiary
                )
            )
        },
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(largePadding())
        ) {
            Title(text = R.string.add_entry_title_of_entry)
            SmallSpacer()
            SingleLineTextFields(textValue = "Day ${challengeProgress + 1}") { title ->
                titleValue = title
            }
            MediumSpacer()

            Title(text = R.string.add_entry_description)
            SmallSpacer()
            MultiLineTextFields { description ->
                descriptionValue = description
            }
            MediumSpacer()

            Title(text = R.string.add_entry_mood_title)
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.sharp_mood_bad_24),
                    contentDescription = stringResource(id = R.string.add_entry_icon_bad_mood)
                )

                Slider(
                    value = sliderValue,
                    onValueChange = { newValue ->
                        sliderValue = newValue
                    },
                    modifier = Modifier
                        .weight(1f)
                        .padding(horizontal = largePadding()),
                    valueRange = 1f..5f,
                    steps = 3,
                )

                Icon(
                    painter = painterResource(id = R.drawable.baseline_mood_24),
                    contentDescription = stringResource(id = R.string.add_entry_icon_good_mood)
                )
            }
            MediumSpacer()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                SmallIconButton(
                    icon = R.drawable.sharp_edit_calendar_24
                ) {
                    showDatePicker = true
                }
                LargeSpacer()
                Text(
                    text = selectedDate.ifEmpty { stringResource(id = R.string.add_entry_select_date) },
                    modifier = Modifier.padding(largePadding())
                )
            }

            MediumSpacer()

            LargeActionButton(
                icon = R.drawable.ic_launcher_foreground,
                text = R.string.add_entry_validate
            ) {
                if (titleValue.isNotBlank() && descriptionValue.isNotBlank()) {
                    saveData.invoke(titleValue, descriptionValue, sliderValue, selectedDate)
                    if (challengeProgress + 1 == 100) {
                        showEndChallengeDialog = true
                    } else {
                        navController?.popBackStack()
                    }
                } else {
                    Toast.makeText(context, R.string.add_entry_validate_error, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    if (showDatePicker) {
        DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, selectedYear: Int, selectedMonth: Int, selectedDayOfMonth: Int ->
                selectedDate = "$selectedDayOfMonth/${selectedMonth + 1}/$selectedYear"
                calendar.set(selectedYear, selectedMonth, selectedDayOfMonth)
                showDatePicker = false
            },
            year,
            month,
            day
        ).show()
    }

    if (showEndChallengeDialog) {
        BasicAlertDialog(
            onDismissRequest = {
                showEndChallengeDialog = false
                navController?.popBackStack()
            },
            modifier = Modifier.wrapContentSize(),
            properties = DialogProperties(usePlatformDefaultWidth = true)
        ) {
            Surface(modifier = Modifier.wrapContentSize(), shape = RoundedCornerShape(10.dp)) {
                EmptyCard {
                    Column(
                        modifier = Modifier.padding(largePadding()),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        LargeTitle(text = R.string.add_entry_end_challenge)
                        MediumSpacer()
                        LottieWithCoilPlaceholder()
                        MediumSpacer()
                        LargeActionButton(text = R.string.add_entry_end_challenge_button) {
                            navController?.popBackStack()
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun AddEntryPreview() {
    _100_days_of_codeTheme {
        Surface {
            AddEntryScreenContent()
        }
    }
}
