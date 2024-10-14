package com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Entry
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.util.UUID

class AddEntryViewModel(
    private val challengeRepository: ChallengeRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AddEntryState())
    private val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            challengeRepository.getAllChallenges().collect { challenges ->
                val currentChallenge = challenges.find { !it.isCompleted }
                _uiState.update { it.copy(currentChallenge = currentChallenge) }
            }
        }
    }

    fun addEntry(title: String, description: String, mood: Float) {
        viewModelScope.launch {
            val updatedChallenge = uiState.value.currentChallenge?.addEntry(
                Entry(
                    id = UUID.randomUUID().toString(),
                    title = title,
                    content = description,
                    mood = mood.toInt(),
                    date = System.currentTimeMillis()
                )
            )
            updatedChallenge?.let {
                challengeRepository.upsertChallenge(it)
                _uiState.update { state ->
                    state.copy(currentChallenge = updatedChallenge)
                }
            }
        }
    }
}

data class AddEntryState(
    val challenges: List<Challenge> = emptyList(),
    val currentChallenge: Challenge? = null,
)
