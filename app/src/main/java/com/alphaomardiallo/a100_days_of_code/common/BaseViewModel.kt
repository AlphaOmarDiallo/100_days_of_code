package com.alphaomardiallo.a100_days_of_code.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.navigator.AppNavigator
import javax.inject.Inject
import kotlinx.coroutines.launch

class BaseViewModel : ViewModel() {

    @Inject lateinit var appNavigator: AppNavigator

    fun navigateBack() {
        viewModelScope.launch {
            appNavigator.navigateBack()
        }
    }

    fun navigateTo(
        route: String,
        popUpToRoute: String? = null,
        inclusive: Boolean = false,
        isSingleTop: Boolean = false,
    ) {
        viewModelScope.launch {
            appNavigator.navigateTo(
                route,
                popUpToRoute,
                inclusive,
                isSingleTop
            )
        }
    }
}
