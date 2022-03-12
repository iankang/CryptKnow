package com.example.coinloreapi.models

data class CoinLoreResponse<T>(
    val data: T? = null,
    val message: String? = "Error",
    val isOk:Boolean? = false,
    val httpStatus:Int? = 500
)
