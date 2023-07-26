package com.example.texttospeach.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.texttospeach.screens.HomeEmptyStateScreen
import com.example.texttospeach.screens.HomeItemsScreen


@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "HomeItemsScreen" ){

        composable("HomeItemsScreen"){
            HomeItemsScreen(navController = navController)
        }
        composable("HomeEmptyState"){
            HomeEmptyStateScreen(navController = navController)
        }
    }


}