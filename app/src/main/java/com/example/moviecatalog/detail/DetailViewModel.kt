package com.example.moviecatalog.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.Amiibo
import com.example.core.domain.usecase.AmiiboUseCase


class DetailViewModel(private val amiiboUseCase: AmiiboUseCase) : ViewModel() {
    fun setFavoriteAmiibo(tourism: Amiibo, newStatus:Boolean) =
        amiiboUseCase.setFavoriteAmiibo(tourism, newStatus)
}
