package dev.toothlonely.starwarsapp.presentation.screen.filmslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.toothlonely.starwarsapp.data.film.FilmRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class FilmsListViewModel : ViewModel() {

    private val _state = MutableStateFlow<FilmsListState>(FilmsListState.Loading)
    val state = _state.asStateFlow()

    private val repository = FilmRepositoryImpl()

    init {
        loadFilms()
    }

    fun loadFilms() {
        _state.value = FilmsListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val films = repository.getFilms()
                _state.value = FilmsListState.Success(films)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = FilmsListState.Error
            }
        }
    }

}