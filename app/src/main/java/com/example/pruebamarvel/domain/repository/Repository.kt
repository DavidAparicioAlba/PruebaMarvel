package com.example.pruebamarvel.domain.repository

import com.example.pruebamarvel.domain.model.DataModel

interface Repository {
    suspend fun getData(): List<DataModel>
}