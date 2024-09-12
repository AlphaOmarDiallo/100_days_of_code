package com.alphaomardiallo.a100_days_of_code.common.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.alphaomardiallo.a100_days_of_code.common.domain.model.User

@Entity(tableName = "table_user")
data class UserEntity(
    @PrimaryKey(autoGenerate = false) val id: Long = 1,
    val name: String? = null
) {
    fun toDomain(): User {
        return User(
            id = id,
            name = name
        )
    }
}
