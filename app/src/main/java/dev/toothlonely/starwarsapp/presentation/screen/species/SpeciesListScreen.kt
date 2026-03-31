package dev.toothlonely.starwarsapp.presentation.screen.species

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import dev.toothlonely.starwarsapp.presentation.screen.error.ErrorScreen

@Composable
fun SpeciesListScreen(navigateTo: (Screen) -> Unit) {

    val viewModel = viewModel<SpeciesListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is SpeciesListState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is SpeciesListState.Error -> {
            ErrorScreen {
                viewModel.loadSpecies()
            }
        }

        is SpeciesListState.Success -> {

            val listOfSpecies = currentState.species
            SpeciesListScreenContent(listOfSpecies, navigateTo)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    SpeciesListScreen {}
}