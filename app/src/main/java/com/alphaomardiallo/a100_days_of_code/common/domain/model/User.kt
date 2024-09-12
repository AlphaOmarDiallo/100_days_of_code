package com.alphaomardiallo.a100_days_of_code.common.domain.model

import com.alphaomardiallo.a100_days_of_code.common.data.local.entity.UserEntity

data class User(
    val id: Long = 1,
    val name: String? = null
) {
    fun toEntity(): UserEntity {
        return UserEntity(
            id = id,
            name = name
        )
    }
}
