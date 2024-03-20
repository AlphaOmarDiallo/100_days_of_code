package com.alphaomardiallo.a100_days_of_code.feature.loginregistration.domain.util

import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.compose.ui.graphics.Color
import com.alphaomardiallo.a100_days_of_code.R

sealed class Providers(
    @StringRes val login: Int,
    @StringRes val register: Int,
    @StringRes val imageLink: Int,
    @StringRes val imageDescription: Int,
    @ColorRes val backGroundColor: Color,
) {

    data object Github : Providers(
        login = R.string.login_provider_github_support_text_login,
        register = R.string.login_provider_github_support_text_register,
        imageLink = R.string.login_provider_github_link,
        imageDescription = R.string.login_provider_github_description,
        backGroundColor = Color.White
    )

    data object Google : Providers(
        login = R.string.login_provider_google_support_text_login,
        register = R.string.login_provider_google_support_text_register,
        imageLink = R.string.login_provider_google_link,
        imageDescription = R.string.login_provider_google_description,
        backGroundColor = Color(0xFFE4E4E4)
    )
}

fun provideListOfProviders() = listOf(
    Providers.Github,
    Providers.Google
)
