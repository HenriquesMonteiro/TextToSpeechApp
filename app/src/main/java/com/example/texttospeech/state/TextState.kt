package com.example.texttospeech.state

import com.example.texttospeech.data.TextDataClass
import com.example.texttospeech.events.SortType

data class TextState(
    val text: List<TextDataClass> = emptyList(),
    val title: String = "",
    val content: String = "",
    val dateCreated: String= "",
    val isAddingList: Boolean=false,
    val sortType: SortType = SortType.Id,
)
