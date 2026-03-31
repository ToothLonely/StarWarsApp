package dev.toothlonely.starwarsapp.data.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
    private val service: PlanetService
) : PlanetRepository {

    override suspend fun getPlanets(): List<Planet> =
        service.getAllPlanets().results.map { planet ->
            planet.toDomain()
        }

    override suspend fun getPlanet(url: String): Planet =
        service.getPlanetByUrl(url).toDomain()
}