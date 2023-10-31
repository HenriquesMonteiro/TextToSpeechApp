package com.example.texttospeech.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
    event: (TextEvent) -> Unit
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row {
                IconButton(onClick = { navController.navigate("HomeItemsScreen") }) {
                    Image(
                        painterResource(id = R.drawable.arrow_left_line),
                        contentDescription = "Back Button",
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
            ) {
                val title = remember {
                    mutableStateOf("Untitled")
                }
                val content = remember {
                    mutableStateOf("Tap here to continue...")
                }
                BasicTextField(
                    value = title.value,
                    onValueChange = { newTitle ->
                        title.value = newTitle
                    },
                    modifier = Modifier.fillMaxWidth(),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Black, fontSize = 25.sp)
                )
                Spacer(modifier = Modifier.height(6.dp))
                BasicTextField(
                    value = content.value,
                    onValueChange = { newContent ->
                        content.value = newContent
                    },
                    modifier = Modifier.fillMaxWidth(),
                    maxLines = 500,
                    textStyle = TextStyle(color = Color.Black, fontSize = 17.sp)

                )
            }
        }
    }
}


