package com.alphaomardiallo.a100_days_of_code.common.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alphaomardiallo.a100_days_of_code.common.data.model.Entry

@Entity(tableName = "table_challenge")
data class ChallengeEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val declarationOfIntention: String = "",
    val currentProgress: Int = 0,
    val startDate: Long? = null,
    val endDate: Long? = null,
    val isCompleted: Boolean = false,
    val entries: List<Entry>
)
