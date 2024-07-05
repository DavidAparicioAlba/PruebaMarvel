package com.example.pruebamarvel.data.remote

import com.example.pruebamarvel.domain.model.HeroModel
import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun fetchData(): List<HeroModel>
}