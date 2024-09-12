package com.alphaomardiallo.a100_days_of_code.common.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import timber.log.Timber

class MainViewModel(
    private val userRepository: UserRepository,
    private val challengeRepository: ChallengeRepository
) : ViewModel() {

    var state by mutableStateOf(MainState())
        private set

    init {
        shouldShowOnboarding()
    }

    private fun shouldShowOnboarding() {
        viewModelScope.launch(Dispatchers.IO) {
            state = state.copy(
                uiReady = true,
                shouldShowOnboarding = challengeRepository.getAllChallenges().first().isEmpty()
            )
        }
    }
}

data class MainState(
    val uiReady: Boolean = false,
    val shouldShowOnboarding: Boolean = true
)
