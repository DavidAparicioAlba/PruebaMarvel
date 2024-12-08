package com.example.pruebamarvel.domain.model

data class HeroModel(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val urls: List<Url>
)
