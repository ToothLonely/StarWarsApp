package dev.toothlonely.starwarsapp.presentation.screen.characterslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersListViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    private val _state = MutableStateFlow<CharactersListState>(CharactersListState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<CharactersListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadCharacters()
    }

    fun loadCharacters() {
        _state.value = CharactersListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val characters = repository.getCharactersFromApi()
                repository.upsertNewCharactersInCache(characters)
                _state.value = CharactersListState.Success(characters)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val characters = repository.getCharactersFromCache() ?: emptyList()
                if (characters.isEmpty()) _state.value = CharactersListState.Error
                else {
                    _event.send(CharactersListEvent.ShowToastBadConnection)
                    _state.value = CharactersListState.Success(characters)
                }
            }
        }
    }
}