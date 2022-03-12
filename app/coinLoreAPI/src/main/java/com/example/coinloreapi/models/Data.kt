package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("csupply")
    val csupply: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("market_cap_usd")
    val marketCapUsd: String,
    @SerializedName("msupply")
    val msupply: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("nameid")
    val nameid: String,
    @SerializedName("percent_change_1h")
    val percentChange1h: String,
    @SerializedName("percent_change_24h")
    val percentChange24h: String,
    @SerializedName("percent_change_7d")
    val percentChange7d: String,
    @SerializedName("price_btc")
    val priceBtc: String,
    @SerializedName("price_usd")
    val priceUsd: String,
    @SerializedName("rank")
    val rank: Int,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("tsupply")
    val tsupply: String,
    @SerializedName("volume24")
    val volume24: Double,
    @SerializedName("volume24a")
    val volume24a: Double
)