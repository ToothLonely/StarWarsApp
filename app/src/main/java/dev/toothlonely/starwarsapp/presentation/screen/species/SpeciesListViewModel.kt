package dev.toothlonely.starwarsapp.presentation.screen.species

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.toothlonely.starwarsapp.data.species.SpeciesRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SpeciesListViewModel : ViewModel() {

    private val _state = MutableStateFlow<SpeciesListState>(SpeciesListState.Loading)
    val state = _state.asStateFlow()

    private val repository = SpeciesRepositoryImpl()

    init {
        loadSpecies()
    }

    private fun loadSpecies() {
        _state.value = SpeciesListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val species = repository.getSpecies()
                _state.value = SpeciesListState.Success(species)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = SpeciesListState.Error
            }
        }
    }

}