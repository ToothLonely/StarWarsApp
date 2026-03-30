package dev.toothlonely.starwarsapp.data.character

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterService {

    @GET("people")
    suspend fun getAllCharacters(): List<CharacterDto>

    @GET("people/")
    suspend fun search(@Query("search") character: String): CharacterDto

    @GET
    suspend fun getCharacterByUrl(@Url url: String): CharacterDto
}