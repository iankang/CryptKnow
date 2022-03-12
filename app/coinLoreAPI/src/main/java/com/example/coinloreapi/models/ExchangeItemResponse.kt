package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class ExchangeItemResponse(
    @SerializedName("pairs")
    var pairs: List<Pairs>? = null,
    @SerializedName("0")
    var exchangeItemDetail: ExchangeItemDetail? = null
)