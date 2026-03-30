package dev.toothlonely.starwarsapp.presentation.navigation.main

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Main : Screen

    @Serializable
    data class Character(val name: String) : Screen

    @Serializable
    data class Film(val name: String) : Screen

    @Serializable
    data class Planet(val name: String) : Screen

    @Serializable
    data class Species(val name: String) : Screen
}