package dev.toothlonely.starwarsapp.domain

interface CharactersRepository {
    suspend fun getAllCharacters()

    suspend fun searchCharacter(character: String)
}