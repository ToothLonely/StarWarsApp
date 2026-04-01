package dev.toothlonely.starwarsapp.data.species

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.toothlonely.starwarsapp.domain.species.Species

@Entity(
    tableName = "species"
)
data class SpeciesEntity(
    val name: String,
    val classification: String,
    val language: String,
    val homeworld: String,
    @PrimaryKey
    val url: String,
)

fun SpeciesEntity.toDomain() = Species(
    name = this.name,
    classification = this.classification,
    language = this.language,
    homeworld = this.homeworld,
    url = this.url
)