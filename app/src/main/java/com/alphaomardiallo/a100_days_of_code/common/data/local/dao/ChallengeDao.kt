package com.alphaomardiallo.a100_days_of_code.common.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ChallengeDao {

    // Challenge
    @Upsert
    suspend fun upsertChallenge(challenge: ChallengeEntity): Long

    @Delete
    suspend fun deleteChallenge(challenge: ChallengeEntity)

    @Query("SELECT * FROM table_challenge WHERE id = :id")
    fun getChallengeById(id: Long): Flow<ChallengeEntity?>

    @Query("SELECT * FROM table_challenge")
    fun getAllChallenges(): Flow<List<ChallengeEntity>>
}
