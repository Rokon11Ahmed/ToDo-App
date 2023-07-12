package com.example.todoapp.data.repository

import androidx.lifecycle.LiveData
import com.example.todoapp.data.entity.db.Note
import com.example.todoapp.data.entity.db.NoteType

interface ListRepository {
    suspend fun saveNote(isAdd: Boolean, id: Int, title: String, description: String?, type: NoteType, date: Long): Boolean
    fun getNoteById(id: Int): Note
    suspend fun deleteNote(note: Note)
    fun observeAllNotes(): LiveData<List<Note>>
}