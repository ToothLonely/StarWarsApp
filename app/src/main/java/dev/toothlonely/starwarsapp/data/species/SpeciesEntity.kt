package dev.toothlonely.starwarsapp.data.species

import androidx.room.Entity

@Entity(
    tableName = "species"
)
data class SpeciesEntity(
    val name: String,
    val classification: String,
    val language: String,
    val homeworld: String,
    val url: String,
)
