package com.alphaomardiallo.a100_days_of_code.common.presentation

import androidx.lifecycle.ViewModel
import timber.log.Timber

class MainViewModel : ViewModel() {

    fun doSomething() = Timber.d("Something")
}
