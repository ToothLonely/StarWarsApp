package dev.toothlonely.starwarsapp.data.film

import androidx.room.Entity

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
    val url: String,
)
