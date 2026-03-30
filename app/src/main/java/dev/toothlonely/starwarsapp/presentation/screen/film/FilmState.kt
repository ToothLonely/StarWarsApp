package dev.toothlonely.starwarsapp.presentation.screen.film

import dev.toothlonely.starwarsapp.domain.film.Film

sealed interface FilmState {
    data object Loading : FilmState
    data object Error : FilmState
    data class Success(val film: Film) : FilmState
}