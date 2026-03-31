package dev.toothlonely.starwarsapp.presentation.screen.planet

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dev.toothlonely.starwarsapp.data.planet.PlanetRepositoryImpl
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlanetViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val planetUrl = savedStateHandle.toRoute<Screen.Planet>().url
    private val _state = MutableStateFlow<PlanetState>(PlanetState.Loading)
    val state = _state.asStateFlow()

    private val repository = PlanetRepositoryImpl()

    init {
        loadPlanet()
    }

    fun loadPlanet() {
        _state.value = PlanetState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val planet = repository.getPlanet(planetUrl)
                _state.value = PlanetState.Success(planet)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = PlanetState.Error
            }
        }
    }

}