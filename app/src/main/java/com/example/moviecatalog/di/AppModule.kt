package com.example.moviecatalog.di

import com.example.core.domain.usecase.AmiiboInteractor
import com.example.core.domain.usecase.AmiiboUseCase
import com.example.moviecatalog.detail.DetailViewModel
import com.example.moviecatalog.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val useCaseModule = module {
    factory<AmiiboUseCase> { AmiiboInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}