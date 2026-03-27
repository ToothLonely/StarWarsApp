package dev.toothlonely.starwarsapp.data

import retrofit2.http.GET
import retrofit2.http.Path

interface CharactersService {

    @GET("people")
    suspend fun getAllCharacters(): List<CharacterDto>

    @GET("people/")
    suspend fun search(@Path("search") character: String): CharacterDto
}