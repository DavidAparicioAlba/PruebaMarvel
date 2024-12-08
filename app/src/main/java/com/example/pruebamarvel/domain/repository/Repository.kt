package com.example.pruebamarvel.domain.repository

import com.example.pruebamarvel.domain.model.HeroModel

interface Repository {
    suspend fun getData(): List<HeroModel>
}
