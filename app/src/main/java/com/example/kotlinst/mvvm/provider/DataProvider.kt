package com.example.kotlinst.mvvm.provider

import androidx.lifecycle.LiveData
import com.example.kotlinst.mvvm.model.Note
import com.example.kotlinst.mvvm.model.NoteResult
import com.example.kotlinst.mvvm.model.User

interface DataProvider {
    fun getCurrentUser() : LiveData<User?>
    fun subscribeToAllNotes() : LiveData<NoteResult>
    fun saveNote(note: Note) : LiveData<NoteResult>
    fun getNoteById(id: String) : LiveData<NoteResult>
}