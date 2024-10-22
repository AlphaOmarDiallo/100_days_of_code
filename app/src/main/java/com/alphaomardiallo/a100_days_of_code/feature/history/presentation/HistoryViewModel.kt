package com.alphaomardiallo.a100_days_of_code.feature.history.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HistoryViewModel(
    private val challengeRepository: ChallengeRepository
) : ViewModel() {
    private val _uiState = MutableStateFlow(HistoryState())
    val uiState: StateFlow<HistoryState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            challengeRepository.getAllChallenges().collect { challenges ->
                _uiState.update { it.copy(challenges = challenges) }
            }
        }
    }
}

data class HistoryState(
    val challenges: List<Challenge> = emptyList()
)
