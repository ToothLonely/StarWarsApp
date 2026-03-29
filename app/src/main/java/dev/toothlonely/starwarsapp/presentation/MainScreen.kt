package dev.toothlonely.starwarsapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.toothlonely.starwarsapp.data.STUB

@Composable
fun MainScreen(modifier: Modifier) {
    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        SearchString()

        val listOfCharacters = STUB.getCharacters()
        CharactersListScreen(listOfCharacters)
    }
}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {
    MainScreen(Modifier)
}