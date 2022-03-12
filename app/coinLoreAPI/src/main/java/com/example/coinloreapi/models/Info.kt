package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class Info(
    @SerializedName("coins_num")
    val coinsNum: Double,
    @SerializedName("time")
    val time: Double
)