package dev.toothlonely.starwarsapp.presentation.screen.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet

sealed interface PlanetsListState {
    data object Loading : PlanetsListState
    data object Error : PlanetsListState
    data class Success(val planets: List<Planet>) : PlanetsListState
}