package dev.toothlonely.starwarsapp.presentation.screen.film

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.data.film.FilmRepositoryImpl
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FilmViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val filmUrl = savedStateHandle.toRoute<Screen.Film>().url
    private val _state = MutableStateFlow<FilmState>(FilmState.Loading)
    val state = _state.asStateFlow()

    private val repository = FilmRepositoryImpl()

    init {
        loadFilm()
    }

    fun loadFilm() {
        _state.value = FilmState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val film = repository.getFilm(filmUrl)
                _state.value = FilmState.Success(film)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = FilmState.Error
            }
        }
    }

}