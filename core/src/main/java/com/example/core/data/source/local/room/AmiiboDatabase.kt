package com.example.core.data.source.local.room


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.core.data.source.local.entity.AmiiboEntity

@Database(entities = [AmiiboEntity::class], version = 1, exportSchema = false)
abstract class AmiiboDatabase : RoomDatabase() {
    abstract fun amiiboDao(): AmiiboDao
}