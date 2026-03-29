package dev.toothlonely.starwarsapp.presentation

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

@Composable
fun SpeciesListScreen() {

    val listOfSpecies = STUB.getSpecies()

    LazyColumn {
        itemsIndexed(listOfSpecies) { index, item ->
            with(item) {
                val firstLine = name
                val secondLine = "$classification from $homeworld"
                val thirdLine = "Talking on $language"
                Item(firstLine, secondLine, thirdLine)
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

@Composable
@Preview(showBackground = true)
private fun Preview() {
    SpeciesListScreen()
}