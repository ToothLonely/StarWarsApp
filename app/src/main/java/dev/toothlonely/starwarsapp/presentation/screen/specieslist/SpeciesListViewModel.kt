package dev.toothlonely.starwarsapp.presentation.screen.specieslist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.species.SpeciesRepository
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterEvent
import dev.toothlonely.starwarsapp.presentation.screen.character.CharacterState
import dev.toothlonely.starwarsapp.presentation.screen.species.SpeciesEvent
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
class SpeciesListViewModel @Inject constructor(
    private val repository: SpeciesRepository
) : ViewModel() {

    private val _state = MutableStateFlow<SpeciesListState>(SpeciesListState.Loading)
    val state = _state.asStateFlow()

    private val _event = Channel<SpeciesListEvent>()
    val event = _event.receiveAsFlow()

    init {
        loadSpecies()
    }

    fun loadSpecies() {
        _state.value = SpeciesListState.Loading

        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                val species = repository.getSpeciesFormApi()
                repository.upsertNewSpeciesInCache(species)
                _state.value = SpeciesListState.Success(species)
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                val species = repository.getSpeciesFromCache() ?: emptyList()
                if (species.isEmpty()) {
                    _state.value = SpeciesListState.Error
                } else {
                    _event.send(SpeciesListEvent.ShowToastBadConnection)
                    _state.value = SpeciesListState.Success(species)
                }
            }
        }
    }

}