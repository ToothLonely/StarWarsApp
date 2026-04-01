package dev.toothlonely.starwarsapp.presentation.screen.planet

sealed interface PlanetEvent {
    data object ShowToastBadConnection : PlanetEvent
}