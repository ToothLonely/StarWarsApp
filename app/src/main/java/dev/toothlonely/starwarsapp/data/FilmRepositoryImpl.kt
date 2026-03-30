package dev.toothlonely.starwarsapp.data

import dev.toothlonely.starwarsapp.domain.Film
import dev.toothlonely.starwarsapp.domain.FilmRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class FilmRepositoryImpl : FilmRepository {

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

    private val service = retrofit.create(FilmService::class.java)

    override suspend fun getFilms(): List<Film> =
        service.getAllFilms().map { film ->
            film.toDomain()
        }

    override suspend fun getFilm(url: String): Film =
        service.getFilmByUrl(url).toDomain()
}