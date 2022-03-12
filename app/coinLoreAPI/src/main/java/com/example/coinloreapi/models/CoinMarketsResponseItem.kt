package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class CoinMarketsResponseItem(
    @SerializedName("base")
    val base: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("price_usd")
    val priceUsd: Double,
    @SerializedName("quote")
    val quote: String,
    @SerializedName("time")
    val time: Int,
    @SerializedName("volume")
    val volume: Double,
    @SerializedName("volume_usd")
    val volumeUsd: Double
)