package com.alphaomardiallo.a100_days_of_code.common.domain.model

import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity

data class Challenge(
    val id: Long = 0,
    val declarationOfIntention: String = "",
    val currentProgress: Int = 0,
    val startDate: Long? = null,
    val endDate: Long? = null,
    val isCompleted: Boolean = false,
    val entries: List<Entry>
) {
    fun toEntity(): ChallengeEntity {
        return ChallengeEntity(
            id = id,
            declarationOfIntention = declarationOfIntention,
            currentProgress = currentProgress,
            startDate = startDate,
            endDate = endDate,
            isCompleted = isCompleted,
            entries = entries
        )
    }
}
