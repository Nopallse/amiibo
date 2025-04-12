package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.AmiiboResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/amiibo/")
    suspend fun getAmiiboList(): AmiiboResponse

    @GET("api/amiibo/")
    suspend fun getAmiiboByHead(@Query("head") head: String): AmiiboResponse
}