package dev.toothlonely.starwarsapp.presentation.screen.filmslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.film.FilmRepository
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
class FilmsListViewModel @Inject constructor(
    private val repository: FilmRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<FilmsListState>(FilmsListState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<FilmsListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadFilms()
    }

    fun loadFilms() {
        _state.value = FilmsListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val films = repository.getFilmsFromApi()
                repository.upsertNewFilmsInCache(films)
                _state.value = FilmsListState.Success(films)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val films = repository.getFilmsFromCache() ?: emptyList()
                if (films.isEmpty()) {
                    _state.value = FilmsListState.Error
                } else {
                    _event.send(FilmsListEvent.ShowToastBadConnection)
                    _state.value = FilmsListState.Success(films)
                }
            }
        }
    }

}