package dev.toothlonely.starwarsapp.domain.film

interface FilmRepository {
    suspend fun getFilms(): List<Film>

    suspend fun getFilm(url: String): Film
}