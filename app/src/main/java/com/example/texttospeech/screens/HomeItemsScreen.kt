package com.example.texttospeech.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomAppBarDefaults
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.texttospeech.events.SortType
import com.example.texttospeech.events.TextEvent
import com.example.texttospeech.state.TextState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeItemsScreen(
    navController: NavController,
    state: TextState,
    event: (TextEvent) ->  Unit) {
    var showSheet by remember { mutableStateOf(false) }

    if (showSheet) {
        SortTasksSheet(
            onEvent = event,
            state = state
        ) {
            showSheet = false
        }
    }

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
                        IconButton(onClick = { showSheet = true }) {
                            Icon(
                                Icons.Filled.MoreVert,
                                contentDescription = "Sort Tasks"
                            )
                        }
                    },
                    floatingActionButton = {
                        FloatingActionButton(
                            onClick = {
                                navController.navigate("AddTextScreen")
                            },
                            containerColor = BottomAppBarDefaults.bottomAppBarFabColor,
                            elevation = FloatingActionButtonDefaults.bottomAppBarFabElevation(),
                        ) {
                            Icon(Icons.Filled.Add, contentDescription = "Add Note")
                        }
                    }
                )
            }
        }
    ) { paddingValues ->

        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
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
                    TextButton(onClick = { /*TODO*/ }) {

                        Text(text = "New category")
                    }
                }
            }
            items(state.text) { text ->
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = text.title,
                            fontSize = 20.sp
                        )
                        Text(text = text.title, fontSize = 15.sp)
                    }
                }
            }
        }
    }
}
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SortTasksSheet(
        state: TextState,
        onEvent: (TextEvent) -> Unit,
        onDismiss: () -> Unit
    ) {
        val modalBottomSheetState = rememberModalBottomSheetState()
        ModalBottomSheet(
            sheetState = modalBottomSheetState,
            onDismissRequest = {
                onDismiss()
            },
            dragHandle = { BottomSheetDefaults.DragHandle() },
        ) {
            // Sheet content
            Column(
                Modifier
                    .fillMaxSize()
                    .horizontalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                SortType.values().forEach { sortType ->
                    Row(
                        modifier = Modifier.clickable {
                            onEvent(TextEvent.SortText(sortType))
                        },
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextButton(
                            onClick = {
                                onEvent(TextEvent.SortText(sortType))
                            },
                            enabled = state.sortType == sortType
                        ) {
                        }
                    }
                }
            }
        }
    }

