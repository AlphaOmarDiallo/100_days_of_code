package com.alphaomardiallo.a100_days_of_code.feature.learn.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.model.LearnItem
import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.repository.LearningRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class LearningViewModel(private val learningRepository: LearningRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(LearnState())
    val uiState: StateFlow<LearnState> = _uiState

    init {
        viewModelScope.launch {
            learningRepository.getLearning().collect { list ->
                _uiState.update { it.copy(resources = list) }
            }
        }
    }
}

data class LearnState(
    val resources: List<LearnItem> = emptyList(),
)
