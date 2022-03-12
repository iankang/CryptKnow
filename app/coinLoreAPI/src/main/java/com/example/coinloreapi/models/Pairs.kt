package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class Pairs(
    @SerializedName("base")
    var base: String? = null,
    @SerializedName("price")
    var price: Double? = null,
    @SerializedName("price_usd")
    var priceUsd: Double? = null,
    @SerializedName("quote")
    var quote: Any? = null,
    @SerializedName("time")
    var time: Int? = null,
    @SerializedName("volume")
    var volume: Double? = null
)