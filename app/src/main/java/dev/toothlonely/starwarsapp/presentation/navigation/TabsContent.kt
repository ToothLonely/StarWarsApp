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
) {
    HorizontalPager(state = pagerState) { page ->
        when (tabs[page]) {
            is Tab.CharactersList -> CharactersListScreen()
            is Tab.FilmsList -> FilmsListScreen()
            is Tab.PlanetsList -> PlanetsListScreen()
            is Tab.SpeciesList -> SpeciesListScreen()
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

    TabsContent(pager, tabs)
}