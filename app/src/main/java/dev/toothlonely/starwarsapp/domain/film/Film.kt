package dev.toothlonely.starwarsapp.domain.film

data class Film(
    val title: String,
    val releaseDate: String,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val episodeId: Int,
    val url: String,
)