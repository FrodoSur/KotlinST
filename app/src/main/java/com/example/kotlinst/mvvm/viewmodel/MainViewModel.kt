package com.example.kotlinst.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.kotlinst.mvvm.model.Note
import com.example.kotlinst.mvvm.model.NoteResult
import com.example.kotlinst.mvvm.model.NotesRepository


class MainViewModel(notesRepository: NotesRepository) : BaseViewModel<List<Note>?, MainViewState>() {
    private val notesObserver = Observer<NoteResult> { result ->
        result ?: return@Observer
        when(result){
            is NoteResult.Success<*> ->  viewStateLiveData.value = MainViewState(notes = result.data as? List<Note>)
            is NoteResult.Error -> viewStateLiveData.value = MainViewState(error = result.error)
        }
    }

    private val repositoryNotes = notesRepository.getNotes()

    init {
        viewStateLiveData.value = MainViewState()
        repositoryNotes.observeForever (notesObserver)
    }

    override fun onCleared() {
        super.onCleared()
        repositoryNotes.removeObserver(notesObserver)
    }
}