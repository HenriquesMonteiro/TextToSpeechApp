package com.example.TextToSpeech

import com.example.TextToSpeech.data.TextDataClass
import com.example.TextToSpeech.events.SortType

data class TextState(
    val text: List<TextDataClass> = emptyList(),
    val title: String = "",
    val content: String = "",
    val texts: String= "",
    val dataCreated: String= "",
    val isAddingList: Boolean=false,
    val sortType: SortType = SortType.Id,
)
