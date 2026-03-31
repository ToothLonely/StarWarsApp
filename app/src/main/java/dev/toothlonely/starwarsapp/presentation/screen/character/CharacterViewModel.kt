package dev.toothlonely.starwarsapp.presentation.screen.character

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.data.character.CharacterRepositoryImpl
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: CharacterRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val characterUrl = savedStateHandle.toRoute<Screen.Character>().url
    private val _state = MutableStateFlow<CharacterState>(CharacterState.Loading)
    val state = _state.asStateFlow()

    init {
        loadCharacter()
    }

    fun loadCharacter() {
        _state.value = CharacterState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val character = repository.getCharacter(characterUrl)
                _state.value = CharacterState.Success(character)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = CharacterState.Error
            }
        }
    }
}