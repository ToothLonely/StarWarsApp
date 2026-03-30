package dev.toothlonely.starwarsapp.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.data.STUB
import dev.toothlonely.starwarsapp.presentation.navigation.Screen

@Composable
fun PlanetsListScreen(navigateTo: (Screen) -> Unit) {

    val listOfPlanets = STUB.getPlanets()

    LazyColumn {
        itemsIndexed(listOfPlanets) { index, item ->
            with(item) {
                val firstLine = name
                val secondLine = "Population: $population, 1 day is $rotationPeriod hours"
                val thirdLine = "Climate: $climate, terrain: $terrain, gravity: ${gravity}G"
                Item(firstLine, secondLine, thirdLine, Modifier.clickable {
                    navigateTo(Screen.Planet(name = name))
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

@Composable
@Preview(showBackground = true)
private fun Preview() {
    PlanetsListScreen {}
}