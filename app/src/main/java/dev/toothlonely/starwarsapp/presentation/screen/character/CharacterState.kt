package dev.toothlonely.starwarsapp.presentation.screen.character

import dev.toothlonely.starwarsapp.domain.character.Character

sealed interface CharacterState {
    data object Loading : CharacterState
    data object Error : CharacterState
    data class Success(val character: Character) : CharacterState
}