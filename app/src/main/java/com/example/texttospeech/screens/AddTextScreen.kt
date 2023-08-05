package com.example.texttospeech.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.texttospeech.TextState
import com.example.texttospeech.events.TextEvent

@Composable
fun AddTextScreen(
    state: TextState,
    onEvent: (TextEvent) -> Unit
) {

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

        OutlinedTextField(
            value = state.title,
            onValueChange = {
                onEvent(TextEvent.SetTitle(it))
            },
            label = { Text("Add Title") })

        OutlinedTextField(value = state.content,
            onValueChange = {
                onEvent(TextEvent.SetContent(it))
            })
    }
}


