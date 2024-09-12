package com.alphaomardiallo.a100_days_of_code.common.data.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.ChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChallengeRepositoryImp(private val challengeDao: ChallengeDao) : ChallengeRepository {
    override suspend fun upsertChallenge(challenge: Challenge): Long {
        return challengeDao.upsertChallenge(challenge.toEntity())
    }

    override suspend fun deleteChallenge(challenge: Challenge) {
        challengeDao.deleteChallenge(challenge.toEntity())
    }

    override fun getChallengeById(id: Long): Flow<Challenge?> {
        return challengeDao.getChallengeById(id).map { it?.toDomain() }
    }

    override fun getAllChallenges(): Flow<List<Challenge>> {
        return challengeDao.getAllChallenges().map { list -> list.map { it.toDomain() } }
    }
}
