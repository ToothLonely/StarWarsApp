package dev.toothlonely.starwarsapp.presentation.screen.film

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.domain.film.Film
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen

@Composable
fun FilmsListScreenContent(listOfFilms: List<Film>, navigateTo: (Screen) -> Unit) {
    LazyColumn {
        itemsIndexed(listOfFilms) { index, item ->
            with(item) {
                val firstLine = title
                val secondLine =
                    if (episodeId == -1 && releaseDate == "unknown") null
                    else if (episodeId == -1) releaseDate
                    else if (releaseDate == "unknown") "Episode №$episodeId"
                    else "Episode №$episodeId from $releaseDate"
                val thirdLine = "$director, $producer"
                Item(firstLine, secondLine, thirdLine, Modifier.clickable {
                    navigateTo(Screen.Film(url = url))
                })
            }

            if (index < listOfFilms.size) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }
    }
}