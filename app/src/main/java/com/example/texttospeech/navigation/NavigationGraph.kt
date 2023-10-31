package com.example.texttospeech.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.texttospeech.events.TextEvent
import com.example.texttospeech.screens.AddTextScreen
import com.example.texttospeech.screens.HomeItemsScreen
import com.example.texttospeech.state.TextState


@Composable
fun NavigationGraph(
    state: TextState,
    onEvent: (TextEvent) -> Unit
) {

    val navController = rememberNavController()

    NavHost(navController = navController,
        startDestination = "HomeItemsScreen" ){

        composable("HomeItemsScreen"){
            HomeItemsScreen(navController = navController, state = state, event= onEvent)
        }
        composable("AddTextScreen"){
            AddTextScreen(navController = navController, state = state, event= onEvent)
        }
    }


}