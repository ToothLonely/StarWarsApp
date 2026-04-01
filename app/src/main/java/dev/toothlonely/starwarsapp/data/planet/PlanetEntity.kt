package dev.toothlonely.starwarsapp.data.planet

import androidx.room.Entity
import androidx.room.PrimaryKey
import dev.toothlonely.starwarsapp.domain.planet.Planet

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
    @PrimaryKey
    val url: String,
)

fun PlanetEntity.toDomain() = Planet(
    name = this.name,
    gravity = this.gravity,
    population = this.population,
    climate = this.climate,
    terrain = this.terrain,
    rotationPeriod = this.rotationPeriod,
    url = this.url
)