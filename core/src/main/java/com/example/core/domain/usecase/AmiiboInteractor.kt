package com.example.core.domain.usecase

import com.example.core.domain.model.Amiibo
import com.example.core.domain.repository.IAmiiboRepository

class AmiiboInteractor(private val amiiboRepository: IAmiiboRepository) : AmiiboUseCase {
    override fun getAllAmiibo() = amiiboRepository.getAllAmiibo()
    override fun getFavoriteAmiibo() = amiiboRepository.getFavoriteAmiibo()
    override fun setFavoriteAmiibo(amiibo: Amiibo, state: Boolean) =
        amiiboRepository.setFavoriteAmiibo(amiibo, state)
}