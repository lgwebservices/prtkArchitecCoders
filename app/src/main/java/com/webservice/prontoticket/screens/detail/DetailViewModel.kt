package com.webservice.prontoticket.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.webservice.prontoticket.data.Evento
import com.webservice.prontoticket.data.EventosRepository
import kotlinx.coroutines.launch

class DetailViewModel(private val id: Int) : ViewModel() {

    private val repository: EventosRepository = EventosRepository()

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val loading: Boolean = false,
        val evento: Evento? = null
    )

    init {
        viewModelScope.launch {
            state = UiState(loading = true)
            state = UiState(loading = false, evento = repository.findEventoById(id))
        }
    }
}