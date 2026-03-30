package dev.toothlonely.starwarsapp.data.species

import dev.toothlonely.starwarsapp.domain.species.Species

data class SpeciesDto(
    val name: String,
    val classification: String,
    val language: String,
    val homeworld: String,
    val url: String,
)

fun SpeciesDto.toDomain() = Species(
    name = this.name,
    classification = this.classification,
    language = this.language,
    homeworld = this.homeworld,
    url = this.url
)
