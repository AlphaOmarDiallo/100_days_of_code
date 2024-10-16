package com.alphaomardiallo.a100_days_of_code.feature.onboarding.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.UserRepository
import com.alphaomardiallo.a100_days_of_code.common.domain.usecase.StringDateToMillis
import kotlinx.coroutines.launch

class OnBoardingViewModel(
    private val userRepository: UserRepository,
    private val challengeRepository: ChallengeRepository,
    private val stringDateToMillis: StringDateToMillis
) : ViewModel() {

    fun createNewUserAndChallenge(name: String, intention: String, startFrom: Int = 0, date: String = "") {
        viewModelScope.launch {
            userRepository.upsertUser(User(name = name))
            challengeRepository.upsertChallenge(
                Challenge(
                    currentProgress = startFrom,
                    declarationOfIntention = intention,
                    startDate = stringDateToMillis.invoke(date)
                )
            )
        }
    }
}
