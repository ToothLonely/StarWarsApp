package dev.toothlonely.starwarsapp.presentation.screen.species

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
import dev.toothlonely.starwarsapp.domain.species.Species

@Composable
fun SpeciesScreenContent(species: Species, titleTextStyle: TextStyle) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = species.name, style = titleTextStyle)

        Spacer(modifier = Modifier.height(30.dp))

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = "Classification: ${species.classification}")
            Text(text = "Homeworld: ${species.homeworld}")
            Text(text = "Language: ${species.language}")
        }
    }
}