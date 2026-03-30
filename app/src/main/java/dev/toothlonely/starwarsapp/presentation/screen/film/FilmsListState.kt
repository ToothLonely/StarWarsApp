package dev.toothlonely.starwarsapp.presentation.screen.film

import dev.toothlonely.starwarsapp.domain.film.Film

sealed interface FilmsListState {
    data object Loading : FilmsListState
    data object Error : FilmsListState
    data class Success(val films: List<Film>) : FilmsListState
}