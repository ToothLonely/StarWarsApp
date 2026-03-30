package dev.toothlonely.starwarsapp.domain

import dev.toothlonely.starwarsapp.data.CharacterDto

data class Character(
    val name: String,
    val birthYear: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val species: String,
    val url: String,
)

fun Character.toDto() = CharacterDto(
    name = this.name,
    birthYear = this.birthYear,
    gender = this.gender,
    height = this.height,
    homeworld = this.homeworld,
    species = this.species,
    url = this.url
)