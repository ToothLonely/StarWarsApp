package dev.toothlonely.starwarsapp.domain.planet

interface PlanetRepository {
    suspend fun getPlanetsFromApi(): List<Planet>

    suspend fun getPlanetFromApi(url: String): Planet

    suspend fun getPlanetsFromCache(): List<Planet>?

    suspend fun getPlanetFromCache(url: String): Planet?

    suspend fun upsertNewPlanetsInCache(planets: List<Planet>)
}