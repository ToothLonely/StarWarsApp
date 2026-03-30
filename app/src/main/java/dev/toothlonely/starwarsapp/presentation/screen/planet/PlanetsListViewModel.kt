package dev.toothlonely.starwarsapp.presentation.screen.planet

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.toothlonely.starwarsapp.data.planet.PlanetRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PlanetsListViewModel : ViewModel() {

    private val _state = MutableStateFlow<PlanetsListState>(PlanetsListState.Loading)
    val state = _state.asStateFlow()

    private val repository = PlanetRepositoryImpl()

    init {
        loadPlanets()
    }

    private fun loadPlanets() {
        _state.value = PlanetsListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val planets = repository.getPlanets()
                _state.value = PlanetsListState.Success(planets)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _state.value = PlanetsListState.Error
            }
        }
    }

}