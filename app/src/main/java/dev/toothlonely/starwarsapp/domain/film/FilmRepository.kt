package dev.toothlonely.starwarsapp.domain.film

interface FilmRepository {
    suspend fun getFilmsFromApi(): List<Film>

    suspend fun getFilmFromApi(url: String): Film

    suspend fun getFilmsFromCache(): List<Film>?
    suspend fun getFilmFromCache(url: String): Film?
    suspend fun upsertNewFilmsInCache(films: List<Film>)
}