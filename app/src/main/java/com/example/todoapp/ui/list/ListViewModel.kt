package com.example.todoapp.ui.list

import androidx.lifecycle.ViewModel
import com.example.todoapp.data.repository.ListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    listRepository: ListRepository
): ViewModel() {

    val notes = listRepository.observeAllNotes()
}