package com.alphaomardiallo.a100_days_of_code.common.domain.model

import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.ChallengeEntity
import java.util.concurrent.TimeUnit

data class Challenge(
    val id: Long = 0,
    val declarationOfIntention: String = "",
    val currentProgress: Int = 0,
    val startDate: Long? = null,
    val endDate: Long? = null,
    var isCompleted: Boolean = false,
    val entries: List<Entry> = emptyList()
) {
    fun addEntry(newEntry: Entry): Challenge {
        val updatedEntries = entries + newEntry
        val updatedProgress = currentProgress + 1

        return this.copy(
            entries = updatedEntries,
            currentProgress = updatedProgress,
            isCompleted = updatedProgress >= 100,
            endDate = if (updatedProgress >= 100) System.currentTimeMillis() else null
        )
    }

    fun removeEntry(entryToRemove: Entry): Challenge {
        val updatedEntries = entries.filter { it != entryToRemove }
        val updatedProgress = currentProgress - 1

        return this.copy(
            entries = updatedEntries,
            currentProgress = updatedProgress,
            isCompleted = updatedProgress >= 100,
            endDate = if (updatedProgress >= 100) System.currentTimeMillis() else null
        )
    }

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

fun Challenge.getLongestStreak(): Int {
    if (entries.isEmpty()) return 0

    // Sort entries by date to ensure they are in chronological order
    val sortedEntries = entries.sortedBy { it.date }

    var longestStreak = 1
    var currentStreak = 1

    for (i in 1 until sortedEntries.size) {
        val previousDate = sortedEntries[i - 1].date
        val currentDate = sortedEntries[i].date

        // Calculate the difference in days between the two consecutive entries
        val differenceInDays = TimeUnit.MILLISECONDS.toDays(currentDate - previousDate)

        if (differenceInDays == 1L) {
            // If the difference is exactly 1 day, it's a consecutive day
            currentStreak++
        } else if (differenceInDays > 1L) {
            // If there's a gap, reset the current streak
            currentStreak = 1
        }

        // Update the longest streak if the current streak is greater
        longestStreak = maxOf(longestStreak, currentStreak)
    }

    return longestStreak
}

fun List<Challenge>.getOverallLongestStreak(): Int {
    return this.maxOfOrNull { it.getLongestStreak() } ?: 0
}

fun List<Challenge>.getAverageMoodFromCurrentChallenge(): Double? {
    val uncompletedChallenge = this.find { !it.isCompleted }
    uncompletedChallenge ?: return null
    return if (uncompletedChallenge.entries.isNotEmpty()) {
        uncompletedChallenge.entries.map { it.mood }.average()
    } else {
        null
    }
}
