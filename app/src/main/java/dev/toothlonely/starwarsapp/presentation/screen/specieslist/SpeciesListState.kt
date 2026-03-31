package dev.toothlonely.starwarsapp.presentation.screen.specieslist

import dev.toothlonely.starwarsapp.domain.species.Species

sealed interface SpeciesListState {
    data object Loading : SpeciesListState
    data object Error : SpeciesListState
    data class Success(val species: List<Species>) : SpeciesListState
}