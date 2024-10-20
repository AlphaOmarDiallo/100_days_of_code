package com.alphaomardiallo.a100_days_of_code.feature.info.data.model

import com.alphaomardiallo.a100_days_of_code.feature.info.domain.model.App
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AppDto(
    val description: String,
    @SerialName("img_resource") val imgResource: String,
    val name: String,
    @SerialName("playstore_link") val playStoreLink: String
){
    fun toDomain() = App(
        description = description,
        imgResource = imgResource,
        name = name,
        playStoreLink = playStoreLink
    )
}
