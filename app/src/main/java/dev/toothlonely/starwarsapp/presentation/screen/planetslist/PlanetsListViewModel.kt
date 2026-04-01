package dev.toothlonely.starwarsapp.presentation.screen.planetslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.planet.PlanetRepository
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterEvent
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterState
import dev.toothlonely.starwarsapp.presentation.screen.planet.PlanetEvent
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
class PlanetsListViewModel @Inject constructor(
    private val repository: PlanetRepository,
) : ViewModel() {

    private val _state = MutableStateFlow<PlanetsListState>(PlanetsListState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<PlanetsListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadPlanets()
    }

    fun loadPlanets() {
        _state.value = PlanetsListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val planets = repository.getPlanetsFromApi()
                repository.upsertNewPlanetsInCache(planets)
                _state.value = PlanetsListState.Success(planets)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val planets = repository.getPlanetsFromCache() ?: emptyList()
                if (planets.isEmpty()) {
                    _state.value = PlanetsListState.Error
                } else {
                    _event.send(PlanetsListEvent.ShowToastBadConnection)
                    _state.value = PlanetsListState.Success(planets)
                }
            }
        }
    }

}