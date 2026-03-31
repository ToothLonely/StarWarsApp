package dev.toothlonely.starwarsapp.presentation.screen.planet

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.screen.error.ErrorScreen

@Composable
fun PlanetScreen(titleTextStyle: TextStyle) {

    val viewModel = viewModel<PlanetViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is PlanetState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is PlanetState.Error -> {
            ErrorScreen {
                viewModel.loadPlanet()
            }
        }

        is PlanetState.Success -> {
            val planet = currentState.planet
            PlanetScreenContent(planet, titleTextStyle)
        }
    }
}