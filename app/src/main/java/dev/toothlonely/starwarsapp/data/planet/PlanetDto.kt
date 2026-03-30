package dev.toothlonely.starwarsapp.data.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet
import kotlinx.serialization.Serializable

@Serializable
data class PlanetDto(
    val name: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    val rotationPeriod: String? = null,
    val url: String,
)

fun PlanetDto.toDomain() = Planet(
    name = this.name,
    gravity = this.gravity,
    population = this.population,
    climate = this.climate,
    terrain = this.terrain,
    rotationPeriod = this.rotationPeriod ?: "unknown",
    url = this.url,
)
