package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class CoinsTickersResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("info")
    val info: Info
)