package dev.toothlonely.starwarsapp.data.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class PlanetRepositoryImpl : PlanetRepository {

    companion object {
        const val BASE_URL = "https://swapi.dev/api"
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val service = retrofit.create(PlanetService::class.java)

    override suspend fun getPlanets(): List<Planet> =
        service.getAllPlanets().map { planet ->
            planet.toDomain()
        }

    override suspend fun getPlanet(url: String): Planet =
        service.getPlanetByUrl(url).toDomain()
}