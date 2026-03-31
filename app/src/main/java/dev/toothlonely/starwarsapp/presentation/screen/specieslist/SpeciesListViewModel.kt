package dev.toothlonely.starwarsapp.presentation.screen.specieslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.data.species.SpeciesRepositoryImpl
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeciesListViewModel @Inject constructor(
    private val repository: SpeciesRepository
) : ViewModel() {

    private val _state = MutableStateFlow<SpeciesListState>(SpeciesListState.Loading)
    val state = _state.asStateFlow()

    init {
        loadSpecies()
    }

    fun loadSpecies() {
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