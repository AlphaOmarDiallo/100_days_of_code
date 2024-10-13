package com.alphaomardiallo.a100_days_of_code.common.presentation.util

import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User

private val challenges = listOf(
    Challenge(
        declarationOfIntention = "Exploring the world of Android development, building apps that bring ideas to life.",
        currentProgress = 51,
        startDate = null,
        endDate = null,
        isCompleted = false,
        entries = emptyList()
    )
)

fun getPreviewUser() = User(name = "Alpha")

fun getPreviewChallenges() = challenges

fun getPreviewChallenge() = challenges[0]
