package dev.toothlonely.starwarsapp.data.film

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.toothlonely.starwarsapp.domain.film.Film

@Entity(
    tableName = "film"
)
data class FilmEntity(
    val title: String,
    val releaseDate: String,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val episodeId: Int,
    @PrimaryKey
    val url: String,
)

fun FilmEntity.toDomain() = Film(
    title = this.title,
    releaseDate = this.releaseDate,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    episodeId = this.episodeId,
    url = this.url
)