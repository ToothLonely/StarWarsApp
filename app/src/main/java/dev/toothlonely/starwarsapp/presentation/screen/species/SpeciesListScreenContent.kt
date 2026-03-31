package dev.toothlonely.starwarsapp.presentation.screen.species

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.domain.species.Species
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen

@Composable
fun SpeciesListScreenContent(listOfSpecies: List<Species>, navigateTo: (Screen) -> Unit) {
    LazyColumn {
        itemsIndexed(listOfSpecies) { index, item ->
            with(item) {
                val firstLine = name
                val secondLine = "$classification from $homeworld"
                val thirdLine = "Talking on $language"
                Item(firstLine, secondLine, thirdLine, Modifier.clickable {
                    navigateTo(Screen.Species(url = url))
                })
            }

            if (index < listOfSpecies.size) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }
    }
}