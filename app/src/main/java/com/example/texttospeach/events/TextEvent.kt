package com.example.texttospeach.events

import com.example.texttospeach.data.TextDataClass

interface TextEvent {
    object SaveText : TextEvent
    data class SetTitle(val title: String) : TextEvent
    data class SetContent(val content: String) : TextEvent
    data class SetDateCreated(val setDateCreated: String) : TextEvent
    data class SortText(val sortType: SortType) : TextEvent
    data class DeleteText(val title: TextDataClass) : TextEvent
    object ShowDialog : TextEvent
    object HideDialog : TextEvent
}