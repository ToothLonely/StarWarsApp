package dev.toothlonely.starwarsapp.data.character

import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface CharacterService {

    @GET("people")
    suspend fun getAllCharacters(): CharacterResponse

    @GET("people/")
    suspend fun search(@Query("search") character: String): CharacterResponse

    @GET
    suspend fun getCharacterByUrl(@Url url: String): CharacterDto
}