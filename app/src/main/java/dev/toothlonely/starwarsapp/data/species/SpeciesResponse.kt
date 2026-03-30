package dev.toothlonely.starwarsapp.data.species

import kotlinx.serialization.Serializable

@Serializable
data class SpeciesResponse(
    val results: List<SpeciesDto>
)
