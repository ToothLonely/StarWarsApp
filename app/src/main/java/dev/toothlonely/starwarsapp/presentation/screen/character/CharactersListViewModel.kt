package dev.toothlonely.starwarsapp.presentation.screen.character

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.toothlonely.starwarsapp.data.character.CharacterRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CharactersListViewModel : ViewModel() {
    private val _state = MutableStateFlow<CharactersListState>(CharactersListState.Loading)
    val state = _state.asStateFlow()

    private val repository = CharacterRepositoryImpl()

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        _state.value = CharactersListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val characters = repository.getCharacters()
                _state.value = CharactersListState.Success(characters)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = CharactersListState.Error
            }
        }
    }
}