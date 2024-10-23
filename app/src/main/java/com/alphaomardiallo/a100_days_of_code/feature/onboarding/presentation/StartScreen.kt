package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import android.app.DatePickerDialog
import android.content.res.Configuration
import android.widget.DatePicker
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSensitiveActionButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LottieWithCoilPlaceholder
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MultiLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SingleLineTextFields
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallBodyText
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallIconButton
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.largePadding
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.smallPadding
import timber.log.Timber
import java.util.Calendar

@Composable
private fun getTextColor() = MaterialTheme.colorScheme.onPrimaryContainer

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StartScreen(
    firstChallenge: Boolean = true,
    returnButtonAction: () -> Unit = {},
    startButtonAction: (String, String, Int, String) -> Unit = { _, _, _, _ -> }
) {
    var name by remember { mutableStateOf("") }
    var intention by remember { mutableStateOf("") }
    var sliderPosition by remember { mutableFloatStateOf(0f) }

    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)
    var showDatePicker by remember { mutableStateOf(false) }
    var selectedDate by remember { mutableStateOf("$day/${month + 1}/$year") }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    LargeTitle(
                        modifier = Modifier.fillMaxWidth(),
                        text = R.string.onboarding_start_title,
                        align = TextAlign.Center,
                        color = getTextColor()
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors()
                    .copy(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        },
        bottomBar = {
            Row(modifier = Modifier.padding(smallPadding())) {
                if (firstChallenge) {
                    SmallIconButton(modifier = Modifier.padding(end = largePadding())) {
                        returnButtonAction.invoke()
                    }
                }
                LargeSensitiveActionButton(
                    text = R.string.onboarding_start_button_start,
                    icon = R.drawable.sharp_code_24,
                ) {
                    startButtonAction.invoke(
                        name,
                        intention,
                        (sliderPosition * 100).toInt(),
                        selectedDate
                    )
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(largePadding())
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Top
        ) {
            if (firstChallenge) {
                SmallTitle(text = R.string.onboarding_start_name_question)
                SmallBodyText(
                    text = R.string.onboarding_start_name_sub_question,
                    align = TextAlign.Justify
                )
                SmallSpacer()
                SingleLineTextFields(
                    textValue = TextFieldValue(name, selection = TextRange(name.length)),
                    onTextChange = { name = it.text }
                )
                MediumSpacer()
            }

            SmallTitle(text = R.string.onboarding_start_intention_question)
            SmallBodyText(
                text = R.string.onboarding_start_intention_sub_question,
                align = TextAlign.Justify
            )
            SmallSpacer()
            MultiLineTextFields { intention = it }
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
                    text = selectedDate.ifEmpty { stringResource(id = R.string.onboarding_start_start_from_date) },
                    modifier = Modifier.padding(largePadding())
                )
            }
            MediumSpacer()

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LottieWithCoilPlaceholder(
                    iterateForever = false,
                    lottieJson = R.raw.plant_growing,
                    size = 50.dp
                )
                Column(modifier = Modifier.weight(1f)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        SmallTitle(text = R.string.onboarding_start_start_from)
                        SmallSpacer()
                        Text(text = (sliderPosition * 100).toInt().toString())
                    }
                    Slider(
                        value = sliderPosition,
                        valueRange = 0f..0.99f,
                        onValueChange = {
                            sliderPosition = it
                            Timber.e("Slider: $it")
                        }
                    )
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
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun OnBoardingPreview() {
    Theme_100DOC {
        Surface {
            StartScreen()
        }
    }
}
