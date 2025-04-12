package com.example.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.core.data.source.local.entity.AmiiboEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AmiiboDao {
    @Query("SELECT * FROM amiibo")
    fun getAllAmiibo(): Flow<List<AmiiboEntity>>

    @Query("SELECT * FROM amiibo where isFavorite = 1")
    fun getFavoriteAmiibo(): Flow<List<AmiiboEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAmiibo(amiibo: List<AmiiboEntity>)

    @Update
    fun updateFavoriteAmiibo(amiibo: AmiiboEntity)
}