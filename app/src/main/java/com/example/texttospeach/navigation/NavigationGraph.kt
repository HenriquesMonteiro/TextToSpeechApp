package com.example.TextToSpeech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.TextToSpeech.screens.AddTextPrev
import com.example.TextToSpeech.screens.HomeItemsScreen


@Composable
fun NavigationGraph() {

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "HomeItemsScreen" ){

        composable("HomeItemsScreen"){
            HomeItemsScreen(navController = navController)
        }
        composable("AddTextPrev"){
            AddTextPrev(navController = navController)
        }
    }


}