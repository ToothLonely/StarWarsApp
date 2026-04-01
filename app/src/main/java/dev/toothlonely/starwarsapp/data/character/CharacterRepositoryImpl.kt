package dev.toothlonely.starwarsapp.data.character

import dev.toothlonely.starwarsapp.domain.character.Character
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import dev.toothlonely.starwarsapp.domain.character.toEntity
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterService,
    private val dao: CharacterDao
) : CharacterRepository {

    override suspend fun getCharactersFromApi(): List<Character> =
        service.getAllCharacters().results.map { character ->
            character.toDomain()
        }

    override suspend fun getCharacterFromApi(url: String): Character =
        service.getCharacterByUrl(url).toDomain()

    override suspend fun getCharactersFromCache(): List<Character>? =
        dao.getCharacters()?.map { characterEntity ->
            characterEntity.toDomain()
        }

    override suspend fun getCharacterFromCache(url: String): Character? =
        dao.getCharacter(url)?.toDomain()

    override suspend fun upsertNewCharactersInCache(characters: List<Character>) {
        val entities = characters.map { character ->
            character.toEntity()
        }

        dao.upsertNewCharacters(entities)
    }

    override suspend fun search(name: String): Character {
        return service.search(name).results[0].toDomain()
    }


}