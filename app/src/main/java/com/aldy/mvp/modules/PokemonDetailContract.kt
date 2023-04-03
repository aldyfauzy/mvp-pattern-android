package com.aldy.mvp.modules

import com.aldy.mvp.data.model.response.GetPokemonResp

interface PokemonDetailContract {
    interface ViewAction{
        fun initView()
        fun setPokeData(resp: GetPokemonResp)
        fun showLoading(isShow: Boolean)
        fun showError(message: String)
    }

    interface Presenter{
        fun getPokemon(nameId: String)
        fun doCleanupResources()
    }
}