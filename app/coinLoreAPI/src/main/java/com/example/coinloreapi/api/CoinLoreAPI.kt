package com.example.coinloreapi.api

import com.example.coinloreapi.models.GlobalCoinResponse
import retrofit2.Response
import retrofit2.http.GET

interface CoinLoreAPI {

    @GET("api/global/")
    suspend fun getGlobalCoinData():Response<GlobalCoinResponse>
}