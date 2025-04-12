package com.example.favorite

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.AmiiboUseCase

class FavoriteViewModel(amiiboUseCase: AmiiboUseCase) : ViewModel() {
    val favoriteAmiibo = amiiboUseCase.getFavoriteAmiibo().asLiveData()
}
