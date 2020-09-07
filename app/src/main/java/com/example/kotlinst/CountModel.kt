package com.example.kotlinst

import android.os.Handler

class CountModel {
    var count: Int = 0

    fun refreshData(onDataReadyCallback: OnDataReadyCallback) {
        count += 1
        Handler().postDelayed({
            onDataReadyCallback.onDataReady(count)
        },2000)
    }
    interface OnDataReadyCallback {
        fun onDataReady(data: Int)
    }
}