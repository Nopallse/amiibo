package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.Amiibo
import kotlinx.coroutines.flow.Flow

interface IAmiiboRepository {
    fun getAllAmiibo(): Flow<Resource<List<Amiibo>>>
    fun getFavoriteAmiibo(): Flow<List<Amiibo>>
    fun setFavoriteAmiibo(amiibo: Amiibo, state: Boolean)
}