package com.example.pruebamarvel.domain.model

data class Url(
    val type: String,
    val url: String
) {
    val getUrl: String
        get() = url.replace("http:", "https:")
}