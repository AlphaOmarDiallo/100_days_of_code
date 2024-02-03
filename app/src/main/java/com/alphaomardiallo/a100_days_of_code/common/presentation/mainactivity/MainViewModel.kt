package com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.navigator.AppNavigator
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity.model.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@HiltViewModel
class MainViewModel @Inject constructor(
    appNavigator: AppNavigator
): BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    val navigationChannel = appNavigator.navigationChannel

    ///////////////////////////////////////////////////////////////////////////
    // State
    ///////////////////////////////////////////////////////////////////////////

    var mainState by mutableStateOf(MainState())
        private set

    ///////////////////////////////////////////////////////////////////////////
    // Init
    ///////////////////////////////////////////////////////////////////////////

    init {
        initializeApp()
    }

    ///////////////////////////////////////////////////////////////////////////
    // Private Function
    ///////////////////////////////////////////////////////////////////////////

    private fun initializeApp(){
        viewModelScope.launch {
            delay(5000)
            mainState = mainState.copy(splashScreenOn = true)
        }
    }
}