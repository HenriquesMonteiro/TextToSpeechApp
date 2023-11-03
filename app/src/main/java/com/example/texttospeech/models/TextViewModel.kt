package com.example.texttospeech.models

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.texttospeech.data.TextDataBase
import com.example.texttospeech.data.TextDataClass
import com.example.texttospeech.events.SortType
import com.example.texttospeech.events.TextEvent
import com.example.texttospeech.state.TextState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class TextViewModel(private val app : Application) : AndroidViewModel(app)
{
    private val db by lazy {
        Room.databaseBuilder(
            app,
             TextDataBase::class.java,
            "TextDb.db").build()
    }
    private val dao = db.dao
    //empty contact state
    //The sortype will be by default the Data created
    private val _sortType =  MutableStateFlow(SortType.DateCreated)
    //holds the current item or text
    @OptIn(ExperimentalCoroutinesApi::class)
    private val _text = _sortType.flatMapLatest { sortType ->
                when(sortType) {
                    SortType.DateCreated -> dao.getTextOrderedByDate()
                    SortType.Id -> dao.getTextOrderedByID()
                    SortType.Title -> dao.getTextOrderedByTitle()
                }
            } .stateIn(viewModelScope, SharingStarted.WhileSubscribed(), emptyList())
    //to combine multiple flows into one, when executed
    private val _state= MutableStateFlow(TextState())

     val state = combine(_state, _sortType, _text){ state, sortType, text ->
        state.copy(
            text = text,
            sortType = sortType
        )
     }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(   5000), TextState())
    fun onEvent(event: TextEvent){
        when(event){
            is TextEvent.DeleteText -> {
                viewModelScope.launch{
                    dao.deleteText(event.title)
                }
            }
            TextEvent.HideDialog -> TODO()
            TextEvent.SaveText -> {
                val title = state.value.title
                val content = state.value.content
                val dateCreated = state.value.dateCreated

                if(title.isBlank() || content.isBlank() || dateCreated.isBlank()){
                     return
                }
                val text = TextDataClass(
                    title = title,
                    content = content,
                    dataCreated = dateCreated
                )
                viewModelScope.launch {
                    dao.upsertText(text)
                }
                _state.update { it.copy(
                    isAddingList = false,
                    title = "",
                    content = "",
                    dateCreated = ""
                ) }
            }
            is TextEvent.SetContent -> {
                _state.update { it.copy(
                    content = event.content
                ) }
            }
            is TextEvent.SetDateCreated ->  {
                _state.update { it.copy(
                    dateCreated = event.setDateCreated
                ) }
            }
            is TextEvent.SetTitle ->  {
                _state.update { it.copy(
                    title = event.title
                ) }
            }
            TextEvent.ShowDialog -> TODO()
            is TextEvent.SortText ->  {
                _sortType.value = event.sortType
            }
        }
    }

}
