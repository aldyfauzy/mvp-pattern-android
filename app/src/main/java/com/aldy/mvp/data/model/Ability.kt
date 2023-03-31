package com.aldy.mvp.data.model

import com.google.gson.annotations.SerializedName

data class Ability (
    @SerializedName("ability")
    var ability: UrlModel,

    @SerializedName("is_hidden")
    val isHidden: Boolean,

    @SerializedName("slot")
    var slot: Int,
)