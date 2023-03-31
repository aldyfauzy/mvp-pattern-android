package com.aldy.mvp.network

import com.aldy.mvp.data.model.response.GetPokeFormResp
import com.aldy.mvp.data.model.response.GetPokemonResp
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiServices {
    companion object {
        const val POKEMON_DETAIL = "pokemon"
        const val POKEMON_FORM = "pokemon-form"
    }

    @GET("$POKEMON_DETAIL/{nameId}")
    fun getPokemon(@Path("nameId") nameId : String): Observable<GetPokemonResp>

    @GET("$POKEMON_FORM/{nameId}")
    fun getPokemonForm(@Path("nameId") id : String): Observable<GetPokeFormResp>
}