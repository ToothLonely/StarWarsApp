package dev.toothlonely.starwarsapp.data

import dev.toothlonely.starwarsapp.domain.Character

object STUB {

    private val listOfItems = listOf(
        Character(
            name = "Luke",
            birthYear = "1996",
            gender = "male",
            height = "200",
            homeworld = "Tatooine",
            species = "Wookie"
        ),

        Character(
            name = "Luke",
            birthYear = "1996",
            gender = "male",
            height = "200",
            homeworld = "Tatooine",
            species = "Wookie"
        ),

        Character(
            name = "Luke",
            birthYear = "1996",
            gender = "male",
            height = "200",
            homeworld = "Tatooine",
            species = "Wookie"
        ),

        Character(
            name = "Luke",
            birthYear = "1996",
            gender = "male",
            height = "200",
            homeworld = "Tatooine",
            species = "Wookie"
        ),

        Character(
            name = "Luke",
            birthYear = "1996",
            gender = "male",
            height = "200",
            homeworld = "Tatooine",
            species = "Wookie"
        )
    )

    fun getCharacters() = listOfItems
}