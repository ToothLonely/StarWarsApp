package dev.toothlonely.starwarsapp.data.film

import dev.toothlonely.starwarsapp.domain.film.Film
import dev.toothlonely.starwarsapp.domain.film.FilmRepository
import dev.toothlonely.starwarsapp.domain.film.toEntity
import javax.inject.Inject

class FilmRepositoryImpl @Inject constructor(
    private val service: FilmService,
    private val dao: FilmDao
) : FilmRepository {

    override suspend fun getFilmsFromApi(): List<Film> =
        service.getAllFilms().results.map { film ->
            film.toDomain()
        }

    override suspend fun getFilmFromApi(url: String): Film =
        service.getFilmByUrl(url).toDomain()

    override suspend fun getFilmsFromCache(): List<Film>? =
        dao.getFilms()?.map { filmEntity ->
            filmEntity.toDomain()
        }

    override suspend fun getFilmFromCache(url: String): Film? =
        dao.getFilm(url)?.toDomain()

    override suspend fun upsertNewFilmsInCache(films: List<Film>) {
        val entities = films.map { film ->
            film.toEntity()
        }

        dao.upsertNewFilms(entities)
    }
}