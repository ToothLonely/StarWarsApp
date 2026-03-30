package dev.toothlonely.starwarsapp.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.starwarsapp.presentation.navigation.Screen
import dev.toothlonely.starwarsapp.presentation.navigation.Tab
import dev.toothlonely.starwarsapp.presentation.navigation.TabsContent
import dev.toothlonely.starwarsapp.presentation.navigation.TabsNavigation

@Composable
fun MainScreen(modifier: Modifier = Modifier, navigateTo: (Screen) -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        val tabs = listOf(
            Tab.CharactersList,
            Tab.PlanetsList,
            Tab.FilmsList,
            Tab.SpeciesList
        )
        val pagerState = rememberPagerState(pageCount = { tabs.size })

        SearchString()
        TabsNavigation(pager = pagerState, tabs = tabs)
        TabsContent(pagerState = pagerState, tabs = tabs, navigateTo = navigateTo)
    }
}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {
    MainScreen {}
}