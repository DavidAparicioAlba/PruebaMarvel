package com.example.pruebamarvel.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pruebamarvel.domain.model.HeroModel
import com.example.pruebamarvel.domain.usecase.GetDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDataUseCase: GetDataUseCase
) : ViewModel() {

    private val _data = MutableStateFlow<List<HeroModel>>(emptyList())
    val data: StateFlow<List<HeroModel>> get() = _data

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
        fetchData()
    }

    private fun fetchData() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val result = getDataUseCase.execute()
                _data.value = result
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
