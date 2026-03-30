package dev.toothlonely.starwarsapp.presentation.screen.planet

import dev.toothlonely.starwarsapp.domain.planet.Planet

sealed interface PlanetState {
    data object Loading : PlanetState
    data object Error : PlanetState
    data class Success(val planet: Planet) : PlanetState
}