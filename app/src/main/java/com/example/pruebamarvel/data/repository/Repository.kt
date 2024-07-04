package com.example.pruebamarvel.data.repository

import com.example.pruebamarvel.domain.model.DataModel

interface Repository {
    suspend fun getData(): List<DataModel>
}