package dev.toothlonely.starwarsapp.presentation.screen.characterslist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.domain.character.Character
import dev.toothlonely.starwarsapp.presentation.component.Item
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen

@Composable
fun CharactersListScreenContent(listOfCharacters: List<Character>, navigateTo: (Screen) -> Unit) {
    LazyColumn {
        itemsIndexed(listOfCharacters) { index, item ->
            with(item) {
                val firstLine = name
                val secondLine = gender
                val thirdLine = height
                Item(firstLine, secondLine, thirdLine, modifier = Modifier.clickable {
                    navigateTo(Screen.Character(url = url))
                })
            }

            if (index < listOfCharacters.size) {
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.LightGray,
                    modifier = Modifier.padding(horizontal = 5.dp)
                )
            }
        }
    }
}