package com.example.texttospeach.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow


@Dao
interface TextDao {
    @Delete
    suspend fun deleteText(text: TextDataClass)

    @Upsert
    suspend fun upsertText(text: TextDataClass)

    @Query("SELECT * FROM Text ORDER BY Id ASC")
    fun getTextOrderedByID(): Flow<List<TextDataClass>>

    @Query("SELECT * FROM Text ORDER BY dataCreated ASC")
    fun getTextOrderedByTitle(): Flow<List<TextDataClass>>

    @Query("SELECT * FROM Text ORDER BY Title ASC")
    fun getTextOrderedByDate(): Flow<List<TextDataClass>>
}

