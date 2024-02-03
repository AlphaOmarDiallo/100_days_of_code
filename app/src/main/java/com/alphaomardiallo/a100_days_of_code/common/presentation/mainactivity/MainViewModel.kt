package com.alphaomardiallo.a100_days_of_code.common.presentation.mainactivity

import com.alphaomardiallo.a100_days_of_code.common.domain.navigator.AppNavigator
import com.alphaomardiallo.a100_days_of_code.common.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    appNavigator: AppNavigator
): BaseViewModel() {

    ///////////////////////////////////////////////////////////////////////////
    // Data
    ///////////////////////////////////////////////////////////////////////////

    val navigationChannel = appNavigator.navigationChannel

}