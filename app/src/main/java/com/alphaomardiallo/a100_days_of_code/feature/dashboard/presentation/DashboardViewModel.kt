package com.alphaomardiallo.a100_days_of_code.feature.dashboard.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class DashboardViewModel(
    private val userRepository: UserRepository,
    private val challengeRepository: ChallengeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(DashboardState())
    val uiState: StateFlow<DashboardState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserById(1).collect { user ->
                _uiState.update { it.copy(user = user) }
            }
        }
    }

    fun getChallenges() {
        viewModelScope.launch(Dispatchers.IO) {
            challengeRepository.getAllChallenges().collect { challenges ->
                _uiState.update { it.copy(challenges = challenges) }
            }
        }
    }

    fun createNewUserAndChallenge(name: String, intention: String, startFrom: Int = 0) {
        viewModelScope.launch {
            userRepository.upsertUser(User(name = name))
            challengeRepository.upsertChallenge(
                Challenge(
                    currentProgress = startFrom,
                    declarationOfIntention = intention
                )
            )
        }
    }
}

data class DashboardState(
    val user: User? = null,
    val challenges: List<Challenge?> = emptyList()
)
