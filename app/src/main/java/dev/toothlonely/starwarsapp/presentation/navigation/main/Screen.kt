package dev.toothlonely.starwarsapp.presentation.navigation.main

import kotlinx.serialization.Serializable

sealed interface Screen {

    @Serializable
    data object Main : Screen

    @Serializable
    data class Character(val url: String) : Screen

    @Serializable
    data class Film(val url: String) : Screen

    @Serializable
    data class Planet(val url: String) : Screen

    @Serializable
    data class Species(val url: String) : Screen
}