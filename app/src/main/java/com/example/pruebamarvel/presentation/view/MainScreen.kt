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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberImagePainter
import com.example.pruebamarvel.presentation.viewmodel.MainViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel()) {
    val data by viewModel.data.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character List") }
            )
        },
        content = {
            LazyColumn {
                items(data.size) { index ->
                    val item = data[index]
                    ListItem(
                        imageUrl = item.thumbnail.fullPath,
                        title = item.name,
                        subtitle = item.description,
                        onClick = { /* Navigate to detail screen */ }
                    )
                }
            }
        }
    )
}

@Composable
fun ListItem(imageUrl: String, title: String, subtitle: String, onClick: () -> Unit) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)
        .clickable(onClick = onClick)
    ) {
        Image(
            painter = rememberImagePainter(imageUrl),
            contentDescription = null,
            modifier = Modifier.size(64.dp),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Text(text = subtitle, style = MaterialTheme.typography.titleSmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListItem() {
    ListItem(
        imageUrl = "https://via.placeholder.com/150",
        title = "Character Name",
        subtitle = "Character Description",
        onClick = {}
    )
}
