package dev.toothlonely.starwarsapp.data.planet

import androidx.room.Entity

@Entity(
    tableName = "planet"
)
data class PlanetEntity(
    val name: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    val rotationPeriod: String,
    val url: String,
)