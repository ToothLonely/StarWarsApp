package dev.toothlonely.starwarsapp.domain.character

import dev.toothlonely.starwarsapp.data.character.CharacterEntity

data class Character(
    val name: String,
    val birthYear: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val species: List<String>,
    val url: String,
)


fun Character.toEntity() = CharacterEntity(
    name = this.name,
    birthYear = this.birthYear,
    gender = this.gender,
    height = this.height,
    homeworld = this.homeworld,
    url = this.url
)