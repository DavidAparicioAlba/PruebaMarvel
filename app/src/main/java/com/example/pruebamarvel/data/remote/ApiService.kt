package com.example.pruebamarvel.data.remote

import com.example.pruebamarvel.domain.model.HeroModel
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("characters")
    suspend fun fetchCharacters(
        @Query("apikey") apiKey: String,
        @Query("hash") hash: String,
        @Query("ts") timestamp: String
    ): ApiResponse
}

data class ApiResponse(
    val data: ApiData
)

data class ApiData(
    val results: List<HeroModel>
)