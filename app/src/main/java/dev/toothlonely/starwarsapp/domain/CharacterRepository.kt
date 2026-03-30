package dev.toothlonely.starwarsapp.domain

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun search(character: String): Character

    suspend fun getCharacter(url: String): Character
}