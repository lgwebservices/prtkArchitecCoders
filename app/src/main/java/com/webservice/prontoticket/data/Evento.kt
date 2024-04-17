package com.webservice.prontoticket.data

data class Evento (
    val id: Int,
    val nombre: String,
    val breve: String,
    val descripcion: String,
    val imagen: String,
    val imagenPh: String,
    val latitud: String,
    val longitud: String
)
