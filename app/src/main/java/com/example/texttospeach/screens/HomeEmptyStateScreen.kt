package com.example.texttospeach.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.texttospeach.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeEmptyStateScreen (){
    Scaffold(
        topBar ={
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "Text To Speech")
                },
                actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(
                                Icons.Default.Person, contentDescription="Profile"
                            )
                        }
                }
            )
        }
    )
    {paddingValues ->
    Surface(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Icon(
            painterResource(id = R.drawable.contract)
            , contentDescription = "Empty State")
    }

    }
}