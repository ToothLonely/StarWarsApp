package dev.toothlonely.starwarsapp.presentation.screen.characterslist

sealed interface CharactersListEvent {
    data object ShowToastBadConnection : CharactersListEvent
}