package com.example.texttospeech.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.texttospeech.R
import com.example.texttospeech.events.TextEvent
import com.example.texttospeech.state.TextState

@Composable
fun AddTextScreen(
    navController: NavController,
    state: TextState,
    onEvent: (TextEvent) -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ){
                IconButton(onClick = { navController.navigate("HomeItemsScreen") }) {
                    Image(
                        painterResource(id = R.drawable.arrow_left_line),
                        contentDescription = "Back Button",
                        modifier = Modifier.size(24.dp)
                    )
                }
                Button(
                    onClick = {
                        onEvent(TextEvent.SaveText)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
                ) {
                    Text("Save")
                }
            }
        }
    ){ it ->
        Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                TextField(
                    value = state.title,
                    onValueChange = {
                        onEvent(TextEvent.SetTitle(it))
                    },
                    placeholder = {
                        Text(text = "Add Title")
                    },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent
                    ),
                    modifier = Modifier.fillMaxWidth(),
                )
                Divider(Modifier.height(1.dp))
                TextField(
                    value = state.content,
                    onValueChange = { onEvent(TextEvent.SetContent(it))
                    },
                    placeholder = {Text(text = "Add Content")},
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 500,
                    textStyle = TextStyle(color = Color.Black, fontSize = 17.sp),
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent
                    )

                )
            }
    }
}

