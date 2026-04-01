package dev.toothlonely.starwarsapp.data.character

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface CharacterDao {
    @Query(
        """
            SELECT * FROM character
        """
    )
    suspend fun getCharacters(): List<CharacterEntity>?

    @Upsert
    suspend fun upsertNewCharacters(characters: List<CharacterEntity>)

    @Query(
        """
            SELECT * FROM character
            WHERE url = :url
        """
    )
    suspend fun getCharacter(url: String): CharacterEntity?
}