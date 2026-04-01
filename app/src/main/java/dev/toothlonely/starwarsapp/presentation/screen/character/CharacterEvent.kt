package dev.toothlonely.starwarsapp.presentation.screen.character

sealed interface CharacterEvent {
    data object ShowToastBadConnection : CharacterEvent
}