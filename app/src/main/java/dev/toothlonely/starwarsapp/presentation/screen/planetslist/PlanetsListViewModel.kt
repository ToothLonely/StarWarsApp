package dev.toothlonely.starwarsapp.presentation.screen.planetslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.data.planet.PlanetRepositoryImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlanetsListViewModel @Inject constructor(): ViewModel() {

    private val _state = MutableStateFlow<PlanetsListState>(PlanetsListState.Loading)
    val state = _state.asStateFlow()

    private val repository = PlanetRepositoryImpl()

    init {
        loadPlanets()
    }

    fun loadPlanets() {
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