package com.alphaomardiallo.a100_days_of_code.common.data.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.ChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.domain.model.Challenge
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository

class ChallengeRepositoryImp(private val challengeDao: ChallengeDao) : ChallengeRepository {
    override suspend fun upsertChallenge(challenge: Challenge): Long {
        return challengeDao.upsertChallenge(challenge.toEntity())
    }

    override suspend fun deleteChallenge(challenge: Challenge) {
        challengeDao.deleteChallenge(challenge.toEntity())
    }

    override suspend fun getChallengeById(id: Long): Challenge? {
        return challengeDao.getChallengeById(id)?.toDomain()
    }

    override suspend fun getAllChallenges(): List<Challenge> {
        return challengeDao.getAllChallenges().map { it.toDomain() }
    }
}
