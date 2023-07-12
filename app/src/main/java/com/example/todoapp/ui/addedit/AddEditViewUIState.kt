package com.example.todoapp.ui.addedit

import com.example.todoapp.data.entity.db.Note

data class AddEditViewUIState (
    var date: Long?,
    var note: Note?
)

sealed class AddEditViewUIEvent {
    data class ShowToast(val messageId: Int) : AddEditViewUIEvent()
    object NavigateToList : AddEditViewUIEvent()
}