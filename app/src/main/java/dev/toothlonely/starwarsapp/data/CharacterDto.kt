package dev.toothlonely.starwarsapp.data

import dev.toothlonely.starwarsapp.domain.Character
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CharacterDto(
    val name: String,
    @SerialName("birth_year")
    val birthYear: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val species: String,
)

fun CharacterDto.toDomain() = Character(
    name = this.name,
    birthYear = this.birthYear,
    gender = this.gender,
    height = this.height,
    homeworld = this.homeworld,
    species = this.species
)
