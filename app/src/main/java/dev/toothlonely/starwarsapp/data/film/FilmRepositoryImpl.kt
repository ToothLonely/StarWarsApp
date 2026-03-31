package dev.toothlonely.starwarsapp.data.film

import dev.toothlonely.starwarsapp.domain.film.Film
import dev.toothlonely.starwarsapp.domain.film.FilmRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val service: FilmService
) : FilmRepository {

    override suspend fun getFilms(): List<Film> =
        service.getAllFilms().results.map { film ->
            film.toDomain()
        }

    override suspend fun getFilm(url: String): Film =
        service.getFilmByUrl(url).toDomain()
}