package com.webservice.prontoticket.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteResult(
    val success: Boolean,
    val data: List<RemoteEvento>
)

@Serializable
data class RemoteResultById(
    val success: Boolean,
    val data: RemoteEvento
)

@Serializable
data class RemoteEvento(
    val id: Int,
    val nombre: String,
    val breve: String,
    val descripcion: String,
    val imagen: String,
    val imagenPh: String,
    val latitud: String,
    val longitud: String
)