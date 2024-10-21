package com.alphaomardiallo.a100_days_of_code.feature.info.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.model.App
import com.alphaomardiallo.a100_days_of_code.feature.info.domain.repository.MyAppsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class InfoViewModel(private val myAppsRepository: MyAppsRepository) : ViewModel() {
    private val _uiState = MutableStateFlow(InfoState())
    val uiState: StateFlow<InfoState> = _uiState

    init {
        viewModelScope.launch(Dispatchers.IO) {
            myAppsRepository.getApps().collect { appList ->
                _uiState.update { state -> state.copy(apps = appList) }
            }
        }
    }
}

data class InfoState(
    val apps: List<App> = emptyList()
)
