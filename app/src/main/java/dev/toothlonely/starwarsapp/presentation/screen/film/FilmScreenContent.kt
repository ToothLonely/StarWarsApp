package dev.toothlonely.starwarsapp.presentation.screen.film

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
import dev.toothlonely.starwarsapp.domain.film.Film

@Composable
fun FilmScreenContent(film: Film, titleTextStyle: TextStyle) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp)
    ) {
        with(film) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(text = title, style = titleTextStyle)

            Spacer(modifier = Modifier.height(30.dp))

            if (openingCrawl.lowercase() != "unknown") {
                Text(text = "Birth year: $openingCrawl")
                Spacer(modifier = Modifier.height(30.dp))
            }

            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                if (episodeId == -1) {
                    Text(text = "Episode number: unknown")
                } else {
                    Text(text = "Episode number: $episodeId")
                }
                Text(text = "Release data: $releaseDate")
                Text(text = "Producer: $producer")
                Text(text = "Director: $director")
            }
        }
    }
}