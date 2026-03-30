package dev.toothlonely.starwarsapp.presentation.screen.planet

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

@Composable
fun PlanetsListScreen(navigateTo: (Screen) -> Unit) {

    //val listOfPlanets = STUB.getPlanets()

    val viewModel = viewModel<PlanetsListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is PlanetsListState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is PlanetsListState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Ошибка")
            }
        }

        is PlanetsListState.Success -> {
            val listOfPlanets = currentState.planets

            LazyColumn {
                itemsIndexed(listOfPlanets) { index, item ->
                    with(item) {
                        val firstLine = name
                        val secondLine = "Population: $population, 1 day is $rotationPeriod hours"
                        val thirdLine = "Climate: $climate, terrain: $terrain, gravity: ${gravity}G"
                        Item(firstLine, secondLine, thirdLine, Modifier.clickable {
                            navigateTo(Screen.Planet(url = url))
                        })
                    }

                    if (index < listOfPlanets.size) {
                        HorizontalDivider(
                            thickness = 1.dp,
                            color = Color.LightGray,
                            modifier = Modifier.padding(horizontal = 5.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    PlanetsListScreen {}
}