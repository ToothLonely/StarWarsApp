package dev.toothlonely.starwarsapp.domain.species

interface SpeciesRepository {
    suspend fun getSpecies(): List<Species>

    suspend fun getSpecies(url: String): Species
}