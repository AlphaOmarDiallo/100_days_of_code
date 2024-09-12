package com.alphaomardiallo.a100_days_of_code.common.domain.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity

interface ChallengeRepository {
    suspend fun upsertChallenge(challenge: ChallengeEntity): Long

    suspend fun deleteChallenge(challenge: ChallengeEntity)

    suspend fun getChallengeById(id: Long): ChallengeEntity?

    suspend fun getAllChallenges(): List<ChallengeEntity>
}
