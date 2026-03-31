package dev.toothlonely.starwarsapp.presentation.screen.character

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.toothlonely.starwarsapp.presentation.component.ErrorScreen

@Composable
fun CharacterScreen(titleTextStyle: TextStyle) {

    val viewModel = viewModel<CharacterViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    when (val currentState = state) {
        is CharacterState.Loading -> {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
        }

        is CharacterState.Error -> {
            ErrorScreen {
                viewModel.loadCharacter()
            }
        }

        is CharacterState.Success -> {

            val character = currentState.character
            CharacterScreenContent(character, titleTextStyle)
        }
    }
}