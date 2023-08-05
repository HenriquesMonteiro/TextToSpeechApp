package com.example.texttospeech.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.texttospeech.data.TextDao
import com.example.texttospeech.data.TextDataClass


@Database(
    entities = [TextDataClass::class],
    version = 1
)
abstract class TextDataBase :RoomDatabase(){
    abstract val dao: TextDao

}