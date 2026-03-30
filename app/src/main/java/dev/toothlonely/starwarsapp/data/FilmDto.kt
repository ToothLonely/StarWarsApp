package dev.toothlonely.starwarsapp.data

import dev.toothlonely.starwarsapp.domain.Film
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
    val title: String,
    val releaseDate: String,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val episodeId: Int,
    val url: String,
)

fun FilmDto.toDomain() = Film(
    title = this.title,
    releaseDate = this.releaseDate,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    episodeId = this.episodeId,
    url = this.url,
)
