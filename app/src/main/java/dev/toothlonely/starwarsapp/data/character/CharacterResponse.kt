package dev.toothlonely.starwarsapp.data.character

import kotlinx.serialization.Serializable

@Serializable
data class CharacterResponse(
    val results: List<CharacterDto>
)
