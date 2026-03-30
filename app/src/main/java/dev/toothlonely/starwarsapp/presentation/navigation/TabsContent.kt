package dev.toothlonely.starwarsapp.presentation.navigation

import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import dev.toothlonely.starwarsapp.presentation.CharactersListScreen
import dev.toothlonely.starwarsapp.presentation.FilmsListScreen
import dev.toothlonely.starwarsapp.presentation.PlanetsListScreen
import dev.toothlonely.starwarsapp.presentation.SpeciesListScreen

@Composable
fun TabsContent(
    pagerState: PagerState,
    tabs: List<Tab>,
    navigateTo: (Screen) -> Unit
) {
    HorizontalPager(state = pagerState) { page ->
        when (tabs[page]) {
            is Tab.CharactersList -> CharactersListScreen(navigateTo)
            is Tab.FilmsList -> FilmsListScreen(navigateTo)
            is Tab.PlanetsList -> PlanetsListScreen(navigateTo)
            is Tab.SpeciesList -> SpeciesListScreen(navigateTo)
        }
    }
}

@Composable
@Preview(showBackground = true)
private fun Preview() {
    val tabs = listOf(
        Tab.CharactersList,
        Tab.PlanetsList,
        Tab.FilmsList,
        Tab.SpeciesList
    )
    val pager = rememberPagerState(pageCount = { tabs.size })

    TabsContent(pager, tabs) {}
}