package dev.toothlonely.starwarsapp.data.planet

import retrofit2.http.GET
import retrofit2.http.Url

interface PlanetService {
    @GET("planets")
    suspend fun getAllPlanets(): List<PlanetDto>

    @GET
    suspend fun getPlanetByUrl(@Url url: String): PlanetDto
}