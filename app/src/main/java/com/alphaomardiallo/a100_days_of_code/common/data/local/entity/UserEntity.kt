package com.alphaomardiallo.a100_days_of_code.common.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = true) val id : Long = 1,
    val name: String? = null
)
