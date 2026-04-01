package dev.toothlonely.starwarsapp.presentation.screen.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.toothlonely.starwarsapp.domain.character.CharacterRepository
import dev.toothlonely.starwarsapp.presentation.navigation.main.MainScreenEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {

    private val _query = MutableStateFlow("")
    val query = _query.asStateFlow()

    private val _event = MutableSharedFlow<MainScreenEvent>(
        replay = 1
    )
    val event = _event.asSharedFlow()

    fun onQueryChanged(newQuery: String) {
        _query.value = newQuery
    }

    fun search() {
        viewModelScope.launch {
            runCatching {
                repository.search(_query.value)
            }.onSuccess { character ->
                _event.emit(MainScreenEvent.NavigateToCharacter(character))
            }.onFailure { error ->
                Log.e("!!!", "${error.message}")
                _event.emit(MainScreenEvent.ShowErrorToast)
            }
        }
    }
}