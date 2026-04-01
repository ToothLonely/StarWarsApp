package dev.toothlonely.starwarsapp.presentation.screen.film

sealed interface FilmEvent {
    data object ShowToastBadConnection : FilmEvent
}