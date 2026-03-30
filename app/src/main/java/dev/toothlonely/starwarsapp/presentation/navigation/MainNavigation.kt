package dev.toothlonely.starwarsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.toothlonely.starwarsapp.presentation.CharacterScreen
import dev.toothlonely.starwarsapp.presentation.FilmScreen
import dev.toothlonely.starwarsapp.presentation.MainScreen
import dev.toothlonely.starwarsapp.presentation.PlanetScreen
import dev.toothlonely.starwarsapp.presentation.SpeciesScreen

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