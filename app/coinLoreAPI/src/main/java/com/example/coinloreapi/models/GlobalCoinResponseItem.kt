package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class GlobalCoinResponseItem(
    @SerializedName("active_markets")
    val activeMarkets: Int,
    @SerializedName("avg_change_percent")
    val avgChangePercent: String,
    @SerializedName("btc_d")
    val btcD: String,
    @SerializedName("coins_count")
    val coinsCount: Int,
    @SerializedName("eth_d")
    val ethD: String,
    @SerializedName("mcap_ath")
    val mcapAth: Double,
    @SerializedName("mcap_change")
    val mcapChange: String,
    @SerializedName("total_mcap")
    val totalMcap: Double,
    @SerializedName("total_volume")
    val totalVolume: Double,
    @SerializedName("volume_ath")
    val volumeAth: Double,
    @SerializedName("volume_change")
    val volumeChange: String
)