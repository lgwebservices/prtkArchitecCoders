package com.webservice.prontoticket.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.webservice.prontoticket.data.Evento
import com.webservice.prontoticket.data.EventosRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val repository: EventosRepository = EventosRepository()

    var uiState by mutableStateOf(UiState())
        private set

    fun onUiReady(region: String) {
        viewModelScope.launch {
            uiState = UiState(loading = true)
            uiState = UiState(loading = false, eventos = repository.fetchEventos())
        }
    }

    data class UiState(
        val loading: Boolean = false,
        val eventos: List<Evento> = emptyList()
    )
}