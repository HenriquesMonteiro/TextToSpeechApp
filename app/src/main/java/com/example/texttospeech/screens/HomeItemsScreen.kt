package com.example.texttospeech.screens


import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeItemsScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text("Text To Speech")
                },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            Icons.Default.Person,
                            contentDescription = "Profile Button"
                        )
                    }
                }
            )
        },
        bottomBar = {
            Row {
                BottomAppBar(
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Check,
                                contentDescription = " Localized Description"
                            )
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Filled.Edit,
                                contentDescription = " Localized Description"
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("AddTextPrev")
                            },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                        ) {
                            Icon(Icons.Filled.Add, contentDescription = "Localized Description")
                        }
                    }
                )
            }
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            color = MaterialTheme.colorScheme.background
        ) {
            Row(
                Modifier
                    .fillMaxSize()
                    .horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Default.Star, contentDescription = "Favourites")
                }
                TextButton(onClick = { /*TODO*/ }
                ) {
                    Text(text = "Favorites")
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Family")
                }
                TextButton(onClick = { /*TODO*/ }) {
                    Text(text = "Entertainment")
                }
                TextButton(onClick = { /*TODO*/ }, ) {

                    Text(text = "New category")
                }
            }
        }

    }
}
