package com.example.kotlinst.mvvm.viewmodel

import com.example.kotlinst.mvvm.model.NoAuthException
import com.example.kotlinst.mvvm.model.NotesRepository


class SplashViewModel() : BaseViewModel<Boolean?, SplashViewState>() {

    fun requestUser(){
        NotesRepository.getCurrentUser().observeForever {
            viewStateLiveData.value = if(it != null){
                SplashViewState(authenticated = true)
            } else {
                SplashViewState(error = NoAuthException())
            }
        }
    }
}