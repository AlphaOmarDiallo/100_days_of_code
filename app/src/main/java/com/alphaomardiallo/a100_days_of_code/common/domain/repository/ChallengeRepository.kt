package com.alphaomardiallo.a100_days_of_code.common.domain.repository

import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge

interface ChallengeRepository {
    suspend fun upsertChallenge(challenge: Challenge): Long

    suspend fun deleteChallenge(challenge: Challenge)

    suspend fun getChallengeById(id: Long): Challenge?

    suspend fun getAllChallenges(): List<Challenge>
}
