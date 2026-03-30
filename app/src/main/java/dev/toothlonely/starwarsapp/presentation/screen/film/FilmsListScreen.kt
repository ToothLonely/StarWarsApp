package dev.toothlonely.starwarsapp.presentation.screen.film

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen

@Composable
fun FilmsListScreen(navigateTo: (Screen) -> Unit) {

    //val listOfFilms = STUB.getFilms()

    val viewModel = viewModel<FilmsListViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is FilmsListState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is FilmsListState.Error -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Ошибка")
            }
        }

        is FilmsListState.Success -> {
            val listOfFilms = currentState.films

            LazyColumn {
                itemsIndexed(listOfFilms) { index, item ->
                    with(item) {
                        val firstLine = title
                        val secondLine = "Episode №$episodeId from $releaseDate"
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
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    FilmsListScreen {}
}
