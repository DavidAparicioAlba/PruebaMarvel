package com.example.pruebamarvel.data

import retrofit2.http.GET

interface ApiService {
    @GET("endpoint")
    suspend fun fetchData(): List<DataModel>
}