package dev.toothlonely.starwarsapp.presentation.navigation.tab

import kotlinx.serialization.Serializable

@Serializable
sealed class Tab(val name: String) {

    @Serializable
    data object CharactersList : Tab(name = "Characters")

    @Serializable
    data object FilmsList : Tab(name = "Films")

    @Serializable
    data object PlanetsList : Tab(name = "Planets")

    @Serializable
    data object SpeciesList : Tab(name = "Species")
}