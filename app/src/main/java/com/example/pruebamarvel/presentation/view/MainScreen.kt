package com.example.pruebamarvel.presentation.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.example.pruebamarvel.R
import com.example.pruebamarvel.presentation.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val data by viewModel.data.collectAsState()
    var (sortedData, setSortedData) = rememberSaveable { mutableStateOf(data) }
    var expanded by remember { mutableStateOf(false) }

    LaunchedEffect(data) {
        sortedData = data // Actualizar sortedData cuando los datos cambien
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Marvel Characters") },
                actions = {
                    SortMenu(onSortChange = { sortOption ->
                        setSortedData(
                            when (sortOption) {
                                SortOption.NAME -> data.sortedBy { it.name }
                                SortOption.ID -> data.sortedBy { it.id }
                            }
                        )
                    })
                }
            )
        },
        content = { paddingValues ->
            CharacterList(
                data = sortedData,
                modifier = Modifier.padding(paddingValues)
            )
        }
    )
}

@Composable
fun SortMenu(onSortChange: (SortOption) -> Unit) {
    var expanded by remember { mutableStateOf(false) }

    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = "Sort Options")
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            onClick = {
                onSortChange(SortOption.NAME)
                expanded = false
            },
            text = {
                Text("Sort by Name")
            })

        DropdownMenuItem(
            onClick = {
                onSortChange(SortOption.ID)
                expanded = false
            },
            text = {
                Text("Sort by ID")
            })
    }
}
