package dev.toothlonely.starwarsapp.data.film

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface FilmDao {

    @Query(
        """
            SELECT * FROM film
        """
    )
    suspend fun getFilms(): List<FilmEntity>?

    @Upsert
    suspend fun upsertNewFilms(films: List<FilmEntity>)

    @Query(
        """
            SELECT * FROM film
            WHERE url = :url
        """
    )
    suspend fun getFilm(url: String): FilmEntity?

}