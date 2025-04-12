package com.example.core.data.source.local


import com.example.core.data.source.local.entity.AmiiboEntity
import com.example.core.data.source.local.room.AmiiboDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val amiiboDao: AmiiboDao) {

    fun getAllAmiibo(): Flow<List<AmiiboEntity>> = amiiboDao.getAllAmiibo()

    fun getFavoriteAmiibo(): Flow<List<AmiiboEntity>> = amiiboDao.getFavoriteAmiibo()

    suspend fun insertAmiibo(amiiboList: List<AmiiboEntity>) = amiiboDao.insertAmiibo(amiiboList)

    fun setFavoriteAmiibo(amiibo: AmiiboEntity, newState: Boolean) {
        amiibo.isFavorite = newState
        amiiboDao.updateFavoriteAmiibo(amiibo)
    }
}