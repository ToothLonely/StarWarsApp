package dev.toothlonely.starwarsapp.data.species

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface SpeciesDao {

    @Query(
        """
            SELECT * FROM species
        """
    )
    suspend fun getSpecies(): List<SpeciesEntity>

    @Upsert
    suspend fun upsertNewSpecies(species: List<SpeciesEntity>)

    @Query(
        """
            SELECT * FROM species
            WHERE name = :name
        """
    )
    suspend fun getSpecies(name: String): SpeciesEntity

}