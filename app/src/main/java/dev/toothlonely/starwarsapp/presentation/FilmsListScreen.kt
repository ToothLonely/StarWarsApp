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
import dev.toothlonely.starwarsapp.domain.Film

@Composable
fun FilmsListScreen(listOfFilms: List<Film>) {
    LazyColumn {
        itemsIndexed(listOfFilms) { index, item ->
            with(item) {
                val firstLine = title
                val secondLine = "Episode №$episodeId from $releaseDate"
                val thirdLine = "$director, $producer"
                Item(firstLine, secondLine, thirdLine)
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

@Composable
@Preview(showBackground = true)
private fun Preview(){
    val listOfFilms = STUB.getFilms()

    FilmsListScreen(listOfFilms)
}
