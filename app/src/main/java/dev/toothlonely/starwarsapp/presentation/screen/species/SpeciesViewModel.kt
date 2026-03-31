package dev.toothlonely.starwarsapp.presentation.screen.species

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.data.species.SpeciesRepositoryImpl
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpeciesViewModel @Inject constructor(
    private val repository: SpeciesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val speciesUrl = savedStateHandle.toRoute<Screen.Species>().url
    private val _state = MutableStateFlow<SpeciesState>(SpeciesState.Loading)
    val state = _state.asStateFlow()


    init {
        loadSpecies()
    }

    fun loadSpecies() {
        _state.value = SpeciesState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val species = repository.getSpecies(speciesUrl)
                _state.value = SpeciesState.Success(species)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = SpeciesState.Error
            }
        }
    }

}