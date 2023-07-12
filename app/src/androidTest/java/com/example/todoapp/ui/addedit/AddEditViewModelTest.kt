package com.example.todoapp.ui.addedit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.todoapp.MainCoroutineRule
import com.example.todoapp.R
import com.example.todoapp.data.entity.db.NoteType
import com.example.todoapp.data.repository.FakeListRepositoryAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class AddEditViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: AddEditViewModel

    @Before
    fun setup() {
        viewModel = AddEditViewModel(FakeListRepositoryAndroidTest())
    }

    @Test
    fun insertEmptyTitleNote() = runBlocking{
        viewModel.addNote(isAdd = true, 0, "", "Description", NoteType.DAILY)
        viewModel.oneShotUiEvents.collect {
            assert(it == AddEditViewUIEvent.ShowToast(R.string.ui_addedit_save_error))
        }
    }
}