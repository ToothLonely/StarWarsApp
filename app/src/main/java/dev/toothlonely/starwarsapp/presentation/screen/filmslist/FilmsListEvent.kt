package dev.toothlonely.starwarsapp.presentation.screen.filmslist

sealed interface FilmsListEvent {
    data object ShowToastBadConnection : FilmsListEvent
}