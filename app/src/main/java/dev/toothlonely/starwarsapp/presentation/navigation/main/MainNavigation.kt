package dev.toothlonely.starwarsapp.presentation.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterScreen
import dev.toothlonely.starwarsapp.presentation.screen.film.FilmScreen
import dev.toothlonely.starwarsapp.presentation.screen.main.MainScreen
import dev.toothlonely.starwarsapp.presentation.screen.planet.PlanetScreen
import dev.toothlonely.starwarsapp.presentation.screen.species.SpeciesScreen

@Composable
fun MainNavigation(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Main,
        modifier = modifier
    ) {
        composable<Screen.Main> {
            MainScreen { destination ->
                navController.navigate(destination)
            }
        }
        composable<Screen.Character> {
            CharacterScreen()
        }
        composable<Screen.Film> {
            FilmScreen()
        }
        composable<Screen.Planet> {
            PlanetScreen()
        }
        composable<Screen.Species> {
            SpeciesScreen()
        }
    }
}