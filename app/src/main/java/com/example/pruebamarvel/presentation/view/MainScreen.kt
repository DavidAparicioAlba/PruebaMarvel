package com.example.pruebamarvel.presentation.view

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pruebamarvel.presentation.viewmodel.MainViewModel

@Composable
fun MainScreen() {
    val viewModel: MainViewModel = hiltViewModel()
    val data = viewModel.data.collectAsState()

    viewModel.fetchData()

    data.value.forEach { item ->
        Text(text = item.toString())
    }
}
