package com.example.core.data

import com.example.core.data.source.local.LocalDataSource
import com.example.core.data.source.remote.RemoteDataSource
import com.example.core.data.source.remote.network.ApiResponse
import com.example.core.data.source.remote.response.AmiiboItem
import com.example.core.domain.model.Amiibo
import com.example.core.domain.repository.IAmiiboRepository
import com.example.core.utils.AppExecutors
import com.example.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AmiiboRepository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : IAmiiboRepository {

    override fun getAllAmiibo(): Flow<Resource<List<Amiibo>>> =
        object : NetworkBoundResource<List<Amiibo>, List<AmiiboItem>>() {
            override fun loadFromDB(): Flow<List<Amiibo>> {
                return localDataSource.getAllAmiibo().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Amiibo>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): Flow<ApiResponse<List<AmiiboItem>>> =
                remoteDataSource.getAllAmiibo()

            override suspend fun saveCallResult(data: List<AmiiboItem>) {
                val amiiboList = DataMapper.mapResponsesToEntities(data)
                localDataSource.insertAmiibo(amiiboList)
            }
        }.asFlow()

    override fun getFavoriteAmiibo(): Flow<List<Amiibo>> {
        return localDataSource.getFavoriteAmiibo().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun setFavoriteAmiibo(amiibo: Amiibo, state: Boolean) {
        val amiiboEntity = DataMapper.mapDomainToEntity(amiibo)
        appExecutors.diskIO().execute { localDataSource.setFavoriteAmiibo(amiiboEntity, state) }
    }
}