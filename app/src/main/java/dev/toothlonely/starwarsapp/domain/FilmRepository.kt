package dev.toothlonely.starwarsapp.domain

interface FilmRepository {
    suspend fun getFilms(): List<Film>

    suspend fun getFilm(url: String): Film
}