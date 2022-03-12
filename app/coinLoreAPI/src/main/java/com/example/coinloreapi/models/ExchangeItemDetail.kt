package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class ExchangeItemDetail(
    @SerializedName("date_live")
    var dateLive: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("url")
    var url: String? = null
)