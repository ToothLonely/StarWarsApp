package dev.toothlonely.starwarsapp.data.planet

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface PlanetDao {

    @Query(
        """
            SELECT * FROM planet
        """
    )
    suspend fun getPlanets(): List<PlanetEntity>

    @Upsert
    suspend fun upsertNewPlanets(planets: List<PlanetEntity>)

    @Query(
        """
            SELECT * FROM planet
            WHERE name = :name
        """
    )
    suspend fun getPlanet(name: String): PlanetEntity

}