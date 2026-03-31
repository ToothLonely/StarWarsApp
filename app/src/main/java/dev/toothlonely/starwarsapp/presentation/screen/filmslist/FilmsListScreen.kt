package dev.toothlonely.starwarsapp.presentation.screen.filmslist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import dev.toothlonely.starwarsapp.presentation.screen.error.ErrorScreen

@Composable
fun FilmsListScreen(navigateTo: (Screen) -> Unit) {

    val viewModel = viewModel<FilmsListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is FilmsListState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is FilmsListState.Error -> {
            ErrorScreen {
                viewModel.loadFilms()
            }
        }

        is FilmsListState.Success -> {
            val listOfFilms = currentState.films
            FilmsListScreenContent(listOfFilms, navigateTo)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    FilmsListScreen {}
}
