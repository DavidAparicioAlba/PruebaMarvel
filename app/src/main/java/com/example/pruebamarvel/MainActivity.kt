package com.example.pruebamarvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pruebamarvel.presentation.view.AppNavigation
import com.example.pruebamarvel.ui.theme.PruebaMarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebaMarvelTheme {
                AppNavigation()
            }
        }
    }
}
