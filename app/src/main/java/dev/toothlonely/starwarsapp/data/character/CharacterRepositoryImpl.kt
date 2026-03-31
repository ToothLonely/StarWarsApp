package dev.toothlonely.starwarsapp.data.character

import dev.toothlonely.starwarsapp.domain.character.Character
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Inject

class CharacterRepositoryImpl @Inject constructor(
    private val service: CharacterService
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> =
        service.getAllCharacters().results.map { character ->
            character.toDomain()
        }

    override suspend fun getCharacter(url: String): Character =
        service.getCharacterByUrl(url).toDomain()
}