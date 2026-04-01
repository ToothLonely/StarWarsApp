package dev.toothlonely.starwarsapp.presentation.navigation.main

import dev.toothlonely.starwarsapp.domain.character.Character

sealed interface MainScreenEvent {
    data class NavigateToCharacter(val character: Character) : MainScreenEvent
    data object ShowErrorToast : MainScreenEvent
}