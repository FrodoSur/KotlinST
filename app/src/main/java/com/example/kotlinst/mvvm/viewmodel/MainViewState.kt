package com.example.kotlinst.mvvm.viewmodel

import com.example.kotlinst.mvvm.model.Note
import com.example.kotlinst.mvvm.viewmodel.BaseViewState

class MainViewState(val notes: List<Note>? = null, error: Throwable? = null) : BaseViewState<List<Note>?>(notes, error)