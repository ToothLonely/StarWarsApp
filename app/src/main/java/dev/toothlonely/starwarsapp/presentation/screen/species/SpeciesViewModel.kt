package dev.toothlonely.starwarsapp.presentation.screen.species

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import dev.toothlonely.starwarsapp.presentation.navigation.main.Screen
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
class SpeciesViewModel @Inject constructor(
    private val repository: SpeciesRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val speciesUrl = savedStateHandle.toRoute<Screen.Species>().url
    private val _state = MutableStateFlow<SpeciesState>(SpeciesState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<SpeciesEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadSpecies()
    }

    fun loadSpecies() {
        _state.value = SpeciesState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val species = repository.getSpeciesFormApi(speciesUrl)
                _state.value = SpeciesState.Success(species)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val species = repository.getSpeciesFromCache(speciesUrl)
                if (species == null) {
                    _state.value = SpeciesState.Error
                } else {
                    _event.send(SpeciesEvent.ShowToastBadConnection)
                    _state.value = SpeciesState.Success(species)
                }
            }
        }
    }

}