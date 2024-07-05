package com.example.pruebamarvel.data.repository

import com.example.pruebamarvel.util.HashGenerator
import com.example.pruebamarvel.data.remote.ApiService
import com.example.pruebamarvel.domain.model.HeroModel
import com.example.pruebamarvel.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun getData(): List<HeroModel> {
        val timestamp = System.currentTimeMillis().toString()
        val hash = HashGenerator.generateHash(timestamp)
        val response = apiService.fetchCharacters(
            apiKey = "54ad444480a8e268521c1d184dcb9d69",
            hash = hash,
            timestamp = timestamp
        )
        return response.data.results
    }
}