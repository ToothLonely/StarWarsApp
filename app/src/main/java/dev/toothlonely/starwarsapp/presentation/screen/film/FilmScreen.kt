package dev.toothlonely.starwarsapp.presentation.screen.film

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.component.ErrorScreen

@Composable
fun FilmScreen(titleTextStyle: TextStyle) {

    val viewModel = viewModel<FilmViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is FilmState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is FilmState.Error -> {
            ErrorScreen {
                viewModel.loadFilm()
            }
        }

        is FilmState.Success -> {
            val film = currentState.film
            FilmScreenContent(film, titleTextStyle)
        }
    }
}