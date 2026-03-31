package dev.toothlonely.starwarsapp.data.film

import dev.toothlonely.starwarsapp.domain.film.Film
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
    val title: String,
    val releaseDate: String? = null,
    val openingCrawl: String? = null,
    val director: String,
    val producer: String,
    val episodeId: Int? = null,
    val url: String,
)

fun FilmDto.toDomain() = Film(
    title = this.title,
    releaseDate = this.releaseDate ?: "unknown",
    openingCrawl = this.openingCrawl ?: "unknown",
    director = this.director,
    producer = this.producer,
    episodeId = this.episodeId ?: -1,
    url = this.url,
)
