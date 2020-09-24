package com.example.kotlinst.mvvm.viewmodel

import com.example.kotlinst.mvvm.model.Note

class NoteViewState(note: Note? = null, error: Throwable? = null) : BaseViewState<Note?>(note, error)