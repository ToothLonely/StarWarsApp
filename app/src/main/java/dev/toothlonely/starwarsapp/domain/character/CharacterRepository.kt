package dev.toothlonely.starwarsapp.domain.character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharacter(url: String): Character
}