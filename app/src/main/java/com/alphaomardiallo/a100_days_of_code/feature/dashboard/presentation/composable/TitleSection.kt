package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation.composable

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.alphaomardiallo.a100_days_of_code.R
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitle
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.LargeTitleString
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.MediumSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.SmallSpacer
import com.alphaomardiallo.a100_days_of_code.common.presentation.composable.Title
import com.alphaomardiallo.a100_days_of_code.common.presentation.theme.Theme_100DOC
import com.alphaomardiallo.a100_days_of_code.common.presentation.util.getPreviewUser

@Composable
fun DashboardTitleSection(user: User? = null) {
    if (user == null) {
        TitleWithoutUser()
    } else {
        TitleWithUser(user)
    }
}

@Composable
private fun TitleWithUser(user: User? = null) {
    Column(modifier = Modifier.fillMaxWidth()) {
        LargeTitleString(
            text = String.format(stringResource(id = R.string.dashboard_title), user?.name)
        )
        SmallSpacer()
        Title(
            text = R.string.dashboard_subtitle
        )
        MediumSpacer()
    }
}

@Composable
private fun TitleWithoutUser() {
    Column(modifier = Modifier.fillMaxWidth()) {
        LargeTitle(text = R.string.dashboard_title_no_user)
        SmallSpacer()
        Title(text = R.string.dashboard_subtitle_no_user)
        MediumSpacer()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true, showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun DashboardTitlePreview() {
    Theme_100DOC {
        Column {
            TitleWithoutUser()
            TitleWithUser(user = getPreviewUser())
        }
    }
}
