package com.alphaomardiallo.a100_days_of_code.common.domain.repository

import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import kotlinx.coroutines.flow.Flow

interface ChallengeRepository {
    suspend fun upsertChallenge(challenge: Challenge): Long

    suspend fun deleteChallenge(challenge: Challenge)

    fun getChallengeById(id: Long): Flow<Challenge?>

    fun getAllChallenges(): Flow<List<Challenge>>
}
