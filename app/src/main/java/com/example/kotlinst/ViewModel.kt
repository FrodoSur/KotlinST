package com.example.kotlinst

import androidx.databinding.ObservableField

class ViewModel {
    var model: CountModel = CountModel()
    val text = ObservableField<String>()

    fun refresh(){
        model.refreshData(object : CountModel.OnDataReadyCallback {
            override fun onDataReady(data: Int) {
                text.set(data.toString())
            }
        })
    }
}