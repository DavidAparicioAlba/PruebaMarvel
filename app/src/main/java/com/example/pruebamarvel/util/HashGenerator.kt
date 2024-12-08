package com.example.pruebamarvel.util

import java.security.MessageDigest

object HashGenerator {
    private const val PUBLIC_KEY = "54ad444480a8e268521c1d184dcb9d69"
    private const val PRIVATE_KEY = "85fe81f8e3bf26f7a55268b0af3c278b6f839792"

    fun generateHash(timestamp: String): String {
        val input = timestamp + PRIVATE_KEY + PUBLIC_KEY
        return md5(input)
    }

    private fun md5(input: String): String {
        val md = MessageDigest.getInstance("MD5")
        return md.digest(input.toByteArray())
            .joinToString("") { "%02x".format(it) }
    }
}
