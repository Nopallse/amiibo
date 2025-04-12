package com.example.moviecatalog.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AmiiboUseCase


class HomeViewModel(amiiboUseCase: AmiiboUseCase) : ViewModel() {
    val amiibo = amiiboUseCase.getAllAmiibo().asLiveData()
}

