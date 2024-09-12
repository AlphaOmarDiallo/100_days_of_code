package com.alphaomardiallo.a100_days_of_code.common.domain.model

data class Entry(
    val id: String = "",
    val date: Long = 0,
    val title: String = "",
    val content: String = "",
    val mood: Int = 3,
)
