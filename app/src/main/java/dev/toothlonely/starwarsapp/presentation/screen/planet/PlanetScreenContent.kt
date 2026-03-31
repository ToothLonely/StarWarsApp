package dev.toothlonely.starwarsapp.presentation.screen.planet

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.domain.planet.Planet

@Composable
fun PlanetScreenContent(planet: Planet, titleTextStyle: TextStyle) {

    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = planet.name, style = titleTextStyle)

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "1 day is: ${planet.rotationPeriod} hours")
            Text(text = "Population: ${planet.population} people")
            Text(text = "Gravity: ${planet.gravity} G")
            Text(text = "Terrain: ${planet.terrain}")
            Text(text = "Climate: ${planet.climate}")
        }
    }

}