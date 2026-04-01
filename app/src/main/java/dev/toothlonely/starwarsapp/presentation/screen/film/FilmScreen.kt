package dev.toothlonely.starwarsapp.presentation.screen.film

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.R
import dev.toothlonely.starwarsapp.presentation.screen.characterslist.CharactersListEvent
import dev.toothlonely.starwarsapp.presentation.screen.error.ErrorScreen

@Composable
fun FilmScreen(titleTextStyle: TextStyle) {

    val viewModel = hiltViewModel<FilmViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val toast = stringResource(R.string.data_from_cache)

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is FilmEvent.ShowToastBadConnection -> Toast.makeText(
                    context,
                    toast,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

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