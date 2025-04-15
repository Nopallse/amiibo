package com.example.core.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "amiibo")
data class AmiiboEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: String, // combination of head+tail as unique identifier

    @ColumnInfo(name = "amiiboSeries")
    val amiiboSeries: String,

    @ColumnInfo(name = "character")
    val character: String,

    @ColumnInfo(name = "gameSeries")
    val gameSeries: String,

    @ColumnInfo(name = "head")
    val head: String,

    @ColumnInfo(name = "image")
    val image: String,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "releaseAu")
    val releaseAu: String?,

    @ColumnInfo(name = "releaseEu")
    val releaseEu: String?,

    @ColumnInfo(name = "releaseJp")
    val releaseJp: String?,

    @ColumnInfo(name = "releaseNa")
    val releaseNa: String?,

    @ColumnInfo(name = "tail")
    val tail: String,

    @ColumnInfo(name = "type")
    val type: String,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false
)