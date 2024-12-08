package com.example.pruebamarvel.presentation.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "main") {
        composable("main") {
            MainScreen(navController = navController)
        }
        composable(
            "detail/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) {
            val characterId = it.arguments?.getInt("characterId")
            characterId?.let {
                CharacterDetailScreen(characterId = characterId, navController = navController)
            }
        }
        composable(
            "webview?url={url}",
            arguments = listOf(navArgument("url") { type = NavType.StringType })
        ) {
            val url = it.arguments?.getString("url") ?: ""
            WebViewScreen(url)
        }
    }
}
