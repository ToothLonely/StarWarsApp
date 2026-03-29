package dev.toothlonely.starwarsapp.domain

interface FilmsRepository {
    suspend fun getFilms(): List<Film>
}