package dev.toothlonely.starwarsapp.domain.character

interface CharacterRepository {
    suspend fun getCharactersFromApi(): List<Character>

    suspend fun getCharacterFromApi(url: String): Character
    suspend fun getCharactersFromCache(): List<Character>?

    suspend fun getCharacterFromCache(url: String): Character?

    suspend fun upsertNewCharactersInCache(characters: List<Character>)
}