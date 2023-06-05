package com.example.texttospeach

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.texttospeach.screens.HomeEmptyStateScreen
import com.example.texttospeach.ui.theme.TextToSpeechTheme


/*sealed class Destination(val route: String){
    object HomeItemsScreen: Destination("HomeItemsScreen")

}*/
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TextToSpeechTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HomeEmptyStateScreen()
                }
            }
        }
    }
}
