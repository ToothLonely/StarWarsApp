package dev.toothlonely.starwarsapp.domain.planet

interface PlanetRepository {
    suspend fun getPlanets(): List<Planet>

    suspend fun getPlanet(url: String): Planet
}