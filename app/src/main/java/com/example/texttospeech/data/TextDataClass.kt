package com.example.texttospeech.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="TextDb")
data class TextDataClass(
    @PrimaryKey(autoGenerate = true)
    val id: Int=0 ,
    val title: String,
    val content: String,
    val dataCreated: String
)
