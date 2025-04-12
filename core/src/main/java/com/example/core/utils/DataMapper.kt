package com.example.core.utils

import com.example.core.data.source.local.entity.AmiiboEntity
import com.example.core.data.source.remote.response.AmiiboItem
import com.example.core.domain.model.Amiibo

object DataMapper {
    fun mapResponsesToEntities(input: List<AmiiboItem>): List<AmiiboEntity> {
        return input.map {
            AmiiboEntity(
                id = "${it.head}${it.tail}",
                amiiboSeries = it.amiiboSeries,
                character = it.character,
                gameSeries = it.gameSeries,
                head = it.head,
                image = it.image,
                name = it.name,
                releaseAu = it.release.au,
                releaseEu = it.release.eu,
                releaseJp = it.release.jp,
                releaseNa = it.release.na,
                tail = it.tail,
                type = it.type,
                isFavorite = false
            )
        }
    }

    fun mapEntitiesToDomain(input: List<AmiiboEntity>): List<Amiibo> =
        input.map {
            Amiibo(
                id = it.id,
                amiiboSeries = it.amiiboSeries,
                character = it.character,
                gameSeries = it.gameSeries,
                head = it.head,
                image = it.image,
                name = it.name,
                releaseAu = it.releaseAu,
                releaseEu = it.releaseEu,
                releaseJp = it.releaseJp,
                releaseNa = it.releaseNa,
                tail = it.tail,
                type = it.type,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Amiibo) = AmiiboEntity(
        id = input.id,
        amiiboSeries = input.amiiboSeries,
        character = input.character,
        gameSeries = input.gameSeries,
        head = input.head,
        image = input.image,
        name = input.name,
        releaseAu = input.releaseAu,
        releaseEu = input.releaseEu,
        releaseJp = input.releaseJp,
        releaseNa = input.releaseNa,
        tail = input.tail,
        type = input.type,
        isFavorite = input.isFavorite
    )
}