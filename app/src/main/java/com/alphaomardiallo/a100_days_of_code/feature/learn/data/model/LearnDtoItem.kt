package com.alphaomardiallo.a100_days_of_code.feature.learn.data.model

import com.alphaomardiallo.a100_days_of_code.feature.learn.domain.model.LearnItem
import kotlinx.serialization.Serializable

@Serializable
data class LearnDtoItem(
    val id: Int,
    val name: String,
    val shortDescription: String,
    val type: String,
    val url: String
) {
    fun toDomain() = LearnItem(
        id = id,
        name = name,
        shortDescription = shortDescription,
        type = type,
        url = url
    )
}
