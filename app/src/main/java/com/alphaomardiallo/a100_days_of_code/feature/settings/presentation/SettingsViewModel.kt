package com.alphaomardiallo.a100_days_of_code.feature.settings.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SettingsViewModel(private val userRepository: UserRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(SettingsState())
    val uiState: StateFlow<SettingsState> = _uiState

    private var updateNameJob: Job? = null

    init {
        viewModelScope.launch(Dispatchers.IO) {
            userRepository.getUserById(1).collect {
                _uiState.value = _uiState.value.copy(userName = it?.name ?: "")
            }
        }
    }

    fun updateUserName(name: String) {
        updateNameJob?.cancel()
        updateNameJob = viewModelScope.launch(Dispatchers.IO) {
            userRepository.upsertUser(User(1, name))
        }
    }
}

data class SettingsState(val userName: String = "")