package com.webservice.prontoticket.data

import retrofit2.http.GET
import retrofit2.http.Path

interface EventosService {

    @GET("evento/getcartelera")
    suspend fun fetchEventos(): RemoteResult

    @GET("evento/getbyid/{id}")
    suspend fun fetchEventoById(@Path("id") id: Int): RemoteResultById
}