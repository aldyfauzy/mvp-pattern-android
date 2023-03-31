package com.aldy.mvp.data.model.response

import com.aldy.mvp.data.model.Sprites
import com.google.gson.annotations.SerializedName

data class GetPokeFormResp (
    @SerializedName("form_name")
    var formName: String? = null,

    @SerializedName("form_order")
    var formOrder: Int? = null,

    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("is_battle_only")
    var isBattleOnly: Boolean? = null,

    @SerializedName("is_default")
    var isDefault: Boolean? = null,

    @SerializedName("is_mega")
    var isMega: Boolean? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("order")
    var order: Int? = null,

    @SerializedName("pokemon")
    var pokemon: Pokemon? = null,

    @SerializedName("sprites")
    var sprites: Sprites? = null

) {
    data class Pokemon (
        @SerializedName("name")
        var name: String,

        @SerializedName("url")
        var url: String,

    )
}