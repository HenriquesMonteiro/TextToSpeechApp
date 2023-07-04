package com.example.texttospeach

import com.example.texttospeach.data.TextDataClass
import com.example.texttospeach.events.SortType

data class TextState(
    val text: List<TextDataClass> = emptyList(),
    val tile: String = "",
    val content: String = "",
    val texts: String= "",
    val dataCreated: String= "",
    val isAddingList: Boolean=false,
    val sortType: SortType = SortType.Id,
)
