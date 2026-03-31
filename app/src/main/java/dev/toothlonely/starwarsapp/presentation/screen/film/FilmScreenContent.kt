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
        Spacer(modifier = Modifier.height(30.dp))

        Text(text = film.title, style = titleTextStyle)

        Spacer(modifier = Modifier.height(30.dp))

        if (film.openingCrawl.lowercase() != "unknown") {
            Text(text = "Birth year: ${film.openingCrawl}")
            Spacer(modifier = Modifier.height(30.dp))
        }

        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Episode number: ${film.episodeId}")
            Text(text = "Release data: ${film.releaseDate}")
            Text(text = "Producer: ${film.producer}")
            Text(text = "Director: ${film.director}")
        }
    }
}