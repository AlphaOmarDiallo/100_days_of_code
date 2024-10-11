package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {

    var state by mutableStateOf(DashboardState())
        private set

    init {
        shouldShowOnboarding()
    }

    private fun shouldShowOnboarding() {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserById(1).collect { user ->
                state = state.copy(
                    uiReady = true,
                    shouldShowOnboarding = user == null
                )
            }
        }
    }
}

data class DashboardState(
    val uiReady: Boolean = false,
    val shouldShowOnboarding: Boolean? = null
)