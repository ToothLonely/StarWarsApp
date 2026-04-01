package dev.toothlonely.starwarsapp.domain.species

interface SpeciesRepository {
    suspend fun getSpeciesFormApi(): List<Species>

    suspend fun getSpeciesFormApi(url: String): Species

    suspend fun getSpeciesFromCache(): List<Species>?

    suspend fun getSpeciesFromCache(url: String): Species?

    suspend fun upsertNewSpeciesInCache(species: List<Species>)
}