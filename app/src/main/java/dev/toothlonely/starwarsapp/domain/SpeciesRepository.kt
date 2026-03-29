package dev.toothlonely.starwarsapp.domain

interface SpeciesRepository {
    suspend fun getSpecies(): List<Species>
}