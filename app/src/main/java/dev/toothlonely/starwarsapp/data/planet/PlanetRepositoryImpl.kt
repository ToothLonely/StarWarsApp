package dev.toothlonely.starwarsapp.data.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import dev.toothlonely.starwarsapp.domain.planet.toEntity
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class PlanetRepositoryImpl @Inject constructor(
    private val service: PlanetService,
    private val dao: PlanetDao
) : PlanetRepository {

    override suspend fun getPlanetsFromApi(): List<Planet> =
        service.getAllPlanets().results.map { planet ->
            planet.toDomain()
        }

    override suspend fun getPlanetFromApi(url: String): Planet =
        service.getPlanetByUrl(url).toDomain()

    override suspend fun getPlanetsFromCache(): List<Planet>? =
        dao.getPlanets()?.map { planetEntity ->
            planetEntity.toDomain()
        }

    override suspend fun getPlanetFromCache(url: String): Planet? =
        dao.getPlanet(url)?.toDomain()

    override suspend fun upsertNewPlanetsInCache(planets: List<Planet>) {
        val entities = planets.map { planet ->
            planet.toEntity()
        }

        dao.upsertNewPlanets(entities)
    }
}