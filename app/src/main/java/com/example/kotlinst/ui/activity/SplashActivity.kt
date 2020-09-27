package com.example.kotlinst.ui.activity

import android.os.Handler
import androidx.lifecycle.ViewModelProvider
import com.example.kotlinst.mvvm.viewmodel.SplashViewModel
import com.example.kotlinst.mvvm.viewmodel.SplashViewState
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : BaseActivity<Boolean?, SplashViewState>(){

    override val viewModel: SplashViewModel by viewModel()

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