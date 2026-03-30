package dev.toothlonely.starwarsapp.data.film

import kotlinx.serialization.Serializable

@Serializable
data class FilmResponse(
    val results: List<FilmDto>
)
