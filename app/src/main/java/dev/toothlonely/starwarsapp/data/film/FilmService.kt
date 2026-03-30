package dev.toothlonely.starwarsapp.data.film

import retrofit2.http.GET
import retrofit2.http.Url

interface FilmService {
    @GET("films")
    suspend fun getAllFilms(): FilmResponse

    @GET
    suspend fun getFilmByUrl(@Url url: String): FilmDto
}