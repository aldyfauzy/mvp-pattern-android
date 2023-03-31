package com.aldy.mvp.data.model.response

import com.aldy.mvp.data.model.Ability
import com.aldy.mvp.data.model.UrlModel
import com.aldy.mvp.data.model.Sprites
import com.google.gson.annotations.SerializedName

data class GetPokemonResp (
    @SerializedName("id")
    var id: Int,

    @SerializedName("name")
    var name: String,

    @SerializedName("abilities")
    var abilities: List<Ability>,

    @SerializedName("base_experience")
    var baseExperience: Int,

    @SerializedName("forms")
    var forms: List<UrlModel>,

    @SerializedName("height")
    var height: Int,

    @SerializedName("is_default")
    var isDefault: Boolean,

    @SerializedName("location_area_encounters")
    var locationAreaEncounters: String,

    @SerializedName("order")
    var order: Int,

    @SerializedName("species")
    var pokeSpecies: UrlModel,

    @SerializedName("sprites")
    var sprites: Sprites,

    @SerializedName("types")
    var types: List<PokeTypes>,

    @SerializedName("weight")
    var weight: Int,
) {
    data class PokeTypes (
        @SerializedName("slot")
        var slot: Int,

        @SerializedName("type")
        var type: UrlModel,
    )
}