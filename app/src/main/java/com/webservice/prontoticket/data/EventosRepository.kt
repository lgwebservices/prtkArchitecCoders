package com.webservice.prontoticket.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class EventosRepository{

    suspend fun fetchEventos(): List<Evento> =
        EventosClient.instance.fetchEventos()
            .data
            .map { it.toDomainModel() }


    suspend fun findEventoById(id: Int): Evento =
        EventosClient.instance.fetchEventoById(id).data.toDomainModel()

}

private fun RemoteEvento.toDomainModel() = Evento(
    id = id,
    nombre = nombre,
    breve = breve,
    descripcion = descripcion,
    imagen = imagen,
    imagenPh = imagenPh,
    latitud = latitud,
    longitud = longitud
)