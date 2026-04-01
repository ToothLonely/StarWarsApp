package dev.toothlonely.starwarsapp.domain.film

import dev.toothlonely.starwarsapp.data.film.FilmEntity

data class Film(
    val title: String,
    val releaseDate: String,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val episodeId: Int,
    val url: String,
)

fun Film.toEntity() = FilmEntity(
    title = this.title,
    releaseDate = this.releaseDate,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    episodeId = this.episodeId,
    url = this.url
)