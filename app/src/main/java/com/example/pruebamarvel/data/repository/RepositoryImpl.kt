package com.example.pruebamarvel.data.repository

import com.example.pruebamarvel.data.remote.ApiService
import com.example.pruebamarvel.domain.model.DataModel
import com.example.pruebamarvel.domain.repository.Repository
import javax.inject.Inject

class RepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : Repository {
    override suspend fun getData(): List<DataModel> {
        return apiService.fetchData()
    }
}