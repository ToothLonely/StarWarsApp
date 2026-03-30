package dev.toothlonely.starwarsapp.data.species

import retrofit2.http.GET
import retrofit2.http.Url

interface SpeciesService {
    @GET("species")
    suspend fun getAllSpecies(): SpeciesResponse

    @GET
    suspend fun getSpeciesByUrl(@Url url: String): SpeciesDto
}