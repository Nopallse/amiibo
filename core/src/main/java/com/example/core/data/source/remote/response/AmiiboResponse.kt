package com.example.core.data.source.remote.response

data class AmiiboResponse(
    val amiibo: List<AmiiboItem>
)

data class AmiiboItem(
    val amiiboSeries: String,
    val character: String,
    val gameSeries: String,
    val head: String,
    val image: String,
    val name: String,
    val release: ReleaseInfo,
    val tail: String,
    val type: String
)

data class ReleaseInfo(
    val au: String?,
    val eu: String?,
    val jp: String?,
    val na: String?
)