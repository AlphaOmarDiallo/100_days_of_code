package com.alphaomardiallo.a100_days_of_code.feature.info.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AppsDto(
    val apps: List<AppDto>
)
