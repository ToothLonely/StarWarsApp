package dev.toothlonely.starwarsapp.presentation.screen.planet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.domain.planet.Planet
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen

@Composable
fun PlanetsListScreenContent(listOfPlanets: List<Planet>, navigateTo: (Screen) -> Unit) {
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