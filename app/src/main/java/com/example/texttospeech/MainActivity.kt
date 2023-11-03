package com.example.texttospeech

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import com.example.texttospeech.models.TextViewModel
import com.example.texttospeech.navigation.NavigationGraph
import com.example.texttospeech.ui.theme.texttospeechTheme


class MainActivity : ComponentActivity() {

    private val viewModel: TextViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            texttospeechTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    NavigationGraph(state = viewModel.state.collectAsState().value, onEvent = viewModel::onEvent )
                }
            }
        }
    }
}
