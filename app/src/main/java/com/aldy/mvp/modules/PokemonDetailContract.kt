package com.aldy.mvp.modules

import com.aldy.mvp.data.model.response.GetPokemonResp

interface PokemonDetailContract {
    interface ViewAction{
        fun initView()
        fun setPokeData(resp: GetPokemonResp)
    }

    interface Presenter{
        fun getPokemon(nameId: String)
        fun doCleanupResources()
    }
}