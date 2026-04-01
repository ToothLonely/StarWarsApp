package dev.toothlonely.starwarsapp.data.species

import dev.toothlonely.starwarsapp.domain.species.Species
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import dev.toothlonely.starwarsapp.domain.species.toEntity
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class SpeciesRepositoryImpl @Inject constructor(
    private val service: SpeciesService,
    private val dao: SpeciesDao
) : SpeciesRepository {
    override suspend fun getSpeciesFormApi(): List<Species> =
        service.getAllSpecies().results.map { species ->
            species.toDomain()
        }

    override suspend fun getSpeciesFormApi(url: String): Species =
        service.getSpeciesByUrl(url).toDomain()

    override suspend fun getSpeciesFromCache(): List<Species>? =
        dao.getSpecies()?.map { speciesEntity ->
            speciesEntity.toDomain()
        }

    override suspend fun getSpeciesFromCache(url: String): Species? =
        dao.getSpecies(url)?.toDomain()

    override suspend fun upsertNewSpeciesInCache(species: List<Species>) {
        val entities = species.map { species ->
            species.toEntity()
        }

        dao.upsertNewSpecies(entities)
    }
}