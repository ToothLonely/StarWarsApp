package dev.toothlonely.starwarsapp.domain

interface PlanetRepository {
    suspend fun getPlanets(): List<Planet>
}