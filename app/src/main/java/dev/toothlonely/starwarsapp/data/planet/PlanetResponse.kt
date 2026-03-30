package dev.toothlonely.starwarsapp.data.planet

import kotlinx.serialization.Serializable

@Serializable
data class PlanetResponse(
    val results: List<PlanetDto>
)
