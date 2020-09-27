package com.example.kotlinst.di
import com.example.kotlinst.mvvm.provider.DataProvider
import com.example.kotlinst.mvvm.provider.FirestoreProvider
import com.example.kotlinst.mvvm.viewmodel.MainViewModel
import com.example.kotlinst.mvvm.viewmodel.NoteViewModel
import com.example.kotlinst.mvvm.viewmodel.SplashViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val appModule = module {
    single { FirebaseAuth.getInstance() }
    single { FirebaseFirestore.getInstance() }
    single<DataProvider> { FirestoreProvider(get(), get()) }
    single { com.example.kotlinst.mvvm.model.NotesRepository(get()) }
}

val splashModule = module {
    viewModel { SplashViewModel(get()) }
}

val mainModule = module {
    viewModel { MainViewModel(get()) }
}

val noteModule = module {
    viewModel { NoteViewModel(get()) }
}