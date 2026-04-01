package dev.toothlonely.starwarsapp.presentation.screen.main

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import dev.toothlonely.starwarsapp.R
import dev.toothlonely.starwarsapp.presentation.component.SearchString
import dev.toothlonely.starwarsapp.presentation.navigation.main.MainScreenEvent
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import dev.toothlonely.starwarsapp.presentation.navigation.tab.Tab
import dev.toothlonely.starwarsapp.presentation.navigation.tab.TabsContent
import dev.toothlonely.starwarsapp.presentation.navigation.tab.TabsNavigation

@Composable
fun MainScreen(modifier: Modifier = Modifier, navigateTo: (Screen) -> Unit) {

    val viewModel = hiltViewModel<MainViewModel>()
    val searchQuery by viewModel.query.collectAsStateWithLifecycle()
    val context = LocalContext.current
    val message = stringResource(R.string.error_search_message)

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is MainScreenEvent.ShowErrorToast -> Toast.makeText(
                    context,
                    message,
                    Toast.LENGTH_SHORT
                ).show()

                is MainScreenEvent.NavigateToCharacter -> {
                    val characterUrl = event.character.url
                    navigateTo(Screen.Character(characterUrl))
                }
            }
        }
    }

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

        SearchString(
            query = searchQuery,
            onQueryChanged = viewModel::onQueryChanged,
            search = viewModel::search
        )
        TabsNavigation(pager = pagerState, tabs = tabs)
        TabsContent(pagerState = pagerState, tabs = tabs, navigateTo = navigateTo)
    }
}

@Composable
@Preview(showBackground = true)
private fun MainScreenPreview() {
    MainScreen {}
}