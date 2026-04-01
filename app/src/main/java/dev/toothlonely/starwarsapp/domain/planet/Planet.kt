package dev.toothlonely.starwarsapp.domain.planet

import dev.toothlonely.starwarsapp.data.planet.PlanetEntity

data class Planet(
    val name: String,
    val gravity: String,
    val population: String,
    val climate: String,
    val terrain: String,
    val rotationPeriod: String,
    val url: String,
)

fun Planet.toEntity() = PlanetEntity(
    name = this.name,
    gravity = this.gravity,
    population = this.population,
    climate = this.climate,
    terrain = this.terrain,
    rotationPeriod = this.rotationPeriod,
    url = this.url
)