package com.alphaomardiallo.a100_days_of_code.feature.addentry.presentation

import androidx.lifecycle.ViewModel
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import timber.log.Timber

class AddEntryViewModel(
    private val challengeRepository: ChallengeRepository
) : ViewModel() {

    init {
        Timber.d("AddEntryViewModel initialized")
    }
}
