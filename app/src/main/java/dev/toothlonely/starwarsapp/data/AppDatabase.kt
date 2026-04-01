package dev.toothlonely.starwarsapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.toothlonely.starwarsapp.data.character.CharacterDao
import dev.toothlonely.starwarsapp.data.character.CharacterEntity
import dev.toothlonely.starwarsapp.data.film.FilmDao
import dev.toothlonely.starwarsapp.data.film.FilmEntity
import dev.toothlonely.starwarsapp.data.planet.PlanetDao
import dev.toothlonely.starwarsapp.data.planet.PlanetEntity
import dev.toothlonely.starwarsapp.data.species.SpeciesDao
import dev.toothlonely.starwarsapp.data.species.SpeciesEntity

@Database(
    version = 1,
    entities = [
        CharacterEntity::class,
        FilmEntity::class,
        PlanetEntity::class,
        SpeciesEntity::class
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getCharacterDao(): CharacterDao
    abstract fun getFilmDao(): FilmDao
    abstract fun getPlanetDao(): PlanetDao
    abstract fun getSpeciesDao(): SpeciesDao
}