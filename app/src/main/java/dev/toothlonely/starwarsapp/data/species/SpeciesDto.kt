package dev.toothlonely.starwarsapp.data.species

import dev.toothlonely.starwarsapp.domain.species.Species
import kotlinx.serialization.Serializable

@Serializable
data class SpeciesDto(
    val name: String,
    val classification: String,
    val language: String,
    val homeworld: String? = null,
    val url: String,
)

fun SpeciesDto.toDomain() = Species(
    name = this.name,
    classification = this.classification,
    language = this.language,
    homeworld = this.homeworld ?: "unknown",
    url = this.url
)
