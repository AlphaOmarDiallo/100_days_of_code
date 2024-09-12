package com.alphaomardiallo.a100_days_of_code.common.data.repository

import com.alphaomardiallo.a100_days_of_code.common.data.local.dao.ChallengeDao
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity
import com.alphaomardiallo.a100_days_of_code.common.domain.repository.ChallengeRepository

class ChallengeRepositoryImp(private val challengeDao: ChallengeDao) : ChallengeRepository {
    override suspend fun upsertChallenge(challenge: ChallengeEntity): Long {
        return challengeDao.upsertChallenge(challenge)
    }

    override suspend fun deleteChallenge(challenge: ChallengeEntity) {
        challengeDao.deleteChallenge(challenge)
    }

    override suspend fun getChallengeById(id: Long): ChallengeEntity? {
        return challengeDao.getChallengeById(id)
    }

    override suspend fun getAllChallenges(): List<ChallengeEntity> {
        return challengeDao.getAllChallenges()
    }
}
