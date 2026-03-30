package dev.toothlonely.starwarsapp.domain

interface SpeciesRepository {
    suspend fun getSpecies(): List<Species>

    suspend fun getSpecies(url: String): Species
}