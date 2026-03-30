package dev.toothlonely.starwarsapp.presentation.screen.character

import dev.toothlonely.starwarsapp.domain.character.Character

sealed interface CharactersListState {
    data object Loading : CharactersListState
    data object Error : CharactersListState
    data class Success(val characters: List<Character>) : CharactersListState
}