package com.example.pruebamarvel.domain.model

data class Thumbnail(
    val path: String,
    val extension: String
) {
    val fullPath: String
        get() = "$path.$extension".replace("http:", "https:")
}