package dev.toothlonely.starwarsapp.presentation.screen.species

sealed interface SpeciesEvent {
    data object ShowToastBadConnection : SpeciesEvent
}