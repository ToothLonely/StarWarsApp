package dev.toothlonely.starwarsapp.data

import dev.toothlonely.starwarsapp.domain.Species
import dev.toothlonely.starwarsapp.domain.SpeciesRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class SpeciesRepositoryImpl : SpeciesRepository {

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

    private val service = retrofit.create(SpeciesService::class.java)

    override suspend fun getSpecies(): List<Species> =
        service.getAllSpecies().map { species ->
            species.toDomain()
        }

    override suspend fun getSpecies(url: String): Species =
        service.getSpeciesByUrl(url).toDomain()
}