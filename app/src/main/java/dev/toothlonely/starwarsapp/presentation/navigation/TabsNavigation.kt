package dev.toothlonely.starwarsapp.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.PrimaryScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun TabsNavigation(
    pager: PagerState,
    tabs: List<Tab>,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()

    Column(
        modifier = modifier
    ) {
        PrimaryScrollableTabRow(
            selectedTabIndex = pager.currentPage,
            edgePadding = 0.dp
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = pager.currentPage == index,
                    onClick = {
                        scope.launch {
                            pager.animateScrollToPage(index)
                        }
                    },
                    text = {
                        Text(text = tab.name)
                    }
                )
            }
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
    TabsNavigation(pager, tabs)
}
