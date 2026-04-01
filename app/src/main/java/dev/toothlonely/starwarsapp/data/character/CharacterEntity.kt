package dev.toothlonely.starwarsapp.data.character

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.toothlonely.starwarsapp.domain.character.Character

@Entity(
    tableName = "character"
)
data class CharacterEntity(
    val birthYear: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val url: String,
    @PrimaryKey
    val name: String,
)

fun CharacterEntity.toDomain() = Character(
    name = this.name,
    birthYear = this.birthYear,
    gender = this.gender,
    height = this.height,
    homeworld = this.homeworld,
    species = emptyList(),
    url = this.url,
)