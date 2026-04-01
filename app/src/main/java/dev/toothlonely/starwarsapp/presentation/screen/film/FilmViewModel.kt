package dev.toothlonely.starwarsapp.presentation.screen.film

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.film.FilmRepository
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterEvent
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterState
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
class FilmViewModel @Inject constructor(
    private val repository: FilmRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val filmUrl = savedStateHandle.toRoute<Screen.Film>().url
    private val _state = MutableStateFlow<FilmState>(FilmState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<FilmEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadFilm()
    }

    fun loadFilm() {
        _state.value = FilmState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val film = repository.getFilmFromApi(filmUrl)
                _state.value = FilmState.Success(film)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val film = repository.getFilmFromCache(filmUrl)
                if (film == null) {
                    _state.value = FilmState.Error
                } else {
                    _event.send(FilmEvent.ShowToastBadConnection)
                    _state.value = FilmState.Success(film)
                }
            }
        }
    }

}