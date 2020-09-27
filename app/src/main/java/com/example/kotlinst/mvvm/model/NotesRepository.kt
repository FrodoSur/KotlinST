package com.example.kotlinst.mvvm.model

import com.example.kotlinst.mvvm.provider.DataProvider
import com.kotlin.example.mvvm.provider.DataProvider
import com.kotlin.example.mvvm.provider.FirestoreProvider
class NotesRepository(val dataProvider: DataProvider
    fun getCurrentUser() = dataProvider.getCurrentUser()
    fun getNotes() = dataProvider.subscribeToAllNotes()
    fun saveNote(note: Note) = dataProvider.saveNote(note)
    fun getNoteById(id: String) = dataProvider.getNoteById(id)
}