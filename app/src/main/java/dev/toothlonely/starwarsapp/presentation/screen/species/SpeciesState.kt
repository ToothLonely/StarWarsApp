package dev.toothlonely.starwarsapp.presentation.screen.species

import dev.toothlonely.starwarsapp.domain.species.Species

sealed interface SpeciesState {
    data object Loading : SpeciesState
    data object Error : SpeciesState
    data class Success(val species: Species) : SpeciesState
}