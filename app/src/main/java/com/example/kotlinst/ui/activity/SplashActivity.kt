package com.example.kotlinst.ui.activity

import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinst.mvvm.viewmodel.SplashViewModel
import com.example.kotlinst.mvvm.viewmodel.SplashViewState

class SplashActivity : BaseActivity<Boolean?, SplashViewState>(){

    override val viewModel by lazy {
        ViewModelProvider(this).get(SplashViewModel::class.java)
    }

    override val layoutRes = null

    override fun onResume() {
        super.onResume()
        Handler().postDelayed({viewModel.requestUser()}, 1000)
    }

    override fun renderData(data: Boolean?) {
        data?.takeIf { it }?.let {
            startMainActivity()
        }
    }

    fun startMainActivity(){
        MainActivity.start(this)
        finish()
    }
}