package com.example.texttospeach.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName="Text")
data class TextDataClass(
    @PrimaryKey(autoGenerate = true)
    val Id: Int=0 ,
    val Title: String,
    val content: String,
    val dataCreated: String

)
