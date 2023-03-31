package com.aldy.mvp.data.model

import com.google.gson.annotations.SerializedName

data class UrlModel (
    @SerializedName("name")
    var name: String,

    @SerializedName("url")
    var url: String,
)