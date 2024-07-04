package com.example.pruebamarvel.domain.usecase

import com.example.pruebamarvel.domain.model.DataModel
import com.example.pruebamarvel.domain.repository.Repository
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val repository: Repository
) {
    suspend fun execute(): List<DataModel> {
        return repository.getData()
    }
}