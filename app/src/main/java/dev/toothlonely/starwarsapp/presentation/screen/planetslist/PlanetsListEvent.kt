package dev.toothlonely.starwarsapp.presentation.screen.planetslist

sealed interface PlanetsListEvent {
    data object ShowToastBadConnection : PlanetsListEvent
}