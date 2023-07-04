package com.example.texttospeach.data

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(
    entities = [TextDataClass::class],
    version = 1
)
abstract class TextDataBase :RoomDatabase(){
    abstract val dao: TextDao

}