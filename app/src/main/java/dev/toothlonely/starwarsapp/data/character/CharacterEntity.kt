package dev.toothlonely.starwarsapp.data.character

import androidx.room.Entity

@Entity(
    tableName = "character"
)
data class CharacterEntity(
    val name: String,
    val birthYear: String,
    val gender: String,
    val height: String,
    val homeworld: String,
    val species: List<String>,
    val url: String,
)
