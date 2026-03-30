package dev.toothlonely.starwarsapp.data.character

import dev.toothlonely.starwarsapp.domain.character.Character
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

class CharacterRepositoryImpl : CharacterRepository {

    companion object {
        const val BASE_URL = "https://swapi.dev/api"
    }

    private val json = Json {
        ignoreUnknownKeys = true
    }

    private val interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    private val client = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
        .build()

    private val service = retrofit.create(CharacterService::class.java)

    override suspend fun getCharacters(): List<Character> =
        service.getAllCharacters().map { character ->
            character.toDomain()
        }

    override suspend fun search(character: String): Character =
        service.search(character).toDomain()

    override suspend fun getCharacter(url: String): Character =
        service.getCharacterByUrl(url).toDomain()
}