package dev.toothlonely.starwarsapp.data.species

import dev.toothlonely.starwarsapp.domain.species.Species
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class SpeciesRepositoryImpl @Inject constructor(
    private val service: SpeciesService
) : SpeciesRepository {
    override suspend fun getSpecies(): List<Species> =
        service.getAllSpecies().results.map { species ->
            species.toDomain()
        }

    override suspend fun getSpecies(url: String): Species =
        service.getSpeciesByUrl(url).toDomain()
}