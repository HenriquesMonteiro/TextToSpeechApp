package com.example.texttospeech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.texttospeech.screens.AddTextPrev
import com.example.texttospeech.screens.HomeItemsScreen


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