package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Amiibo(
    val id: String,
    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val head: String,
    val image: String,
    val name: String,
    val releaseAu: String?,
    val releaseEu: String?,
    val releaseJp: String?,
    val releaseNa: String?,
    val tail: String,
    val type: String,
    val isFavorite: Boolean
) : Parcelable
