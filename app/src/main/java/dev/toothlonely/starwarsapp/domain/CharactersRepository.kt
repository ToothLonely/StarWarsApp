package dev.toothlonely.starwarsapp.domain

interface CharactersRepository {
    suspend fun getAllCharacters(): List<Character>

    suspend fun search(character: String): Character
}