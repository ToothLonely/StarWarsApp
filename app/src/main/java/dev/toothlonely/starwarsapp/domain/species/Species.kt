package dev.toothlonely.starwarsapp.domain.species

import dev.toothlonely.starwarsapp.data.species.SpeciesEntity

data class Species(
    val name: String,
    val classification: String,
    val language: String,
    val homeworld: String,
    val url: String,
)

fun Species.toEntity() = SpeciesEntity(
    name = this.name,
    classification = this.classification,
    language = this.language,
    homeworld = this.homeworld,
    url = this.url
)