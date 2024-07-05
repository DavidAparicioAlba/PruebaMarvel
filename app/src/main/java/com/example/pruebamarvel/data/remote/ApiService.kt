package com.example.pruebamarvel.data.remote

import com.example.pruebamarvel.domain.model.DataModel
import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun fetchData(): List<DataModel>
}