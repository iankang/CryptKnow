package com.example.coinloreapi.api

import com.example.coinloreapi.models.*
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface CoinLoreAPIRequests {

    @GET("api/global/")
    suspend fun getGlobalCoinData(): Response<GlobalCoinResponse>

    @GET("api/tickers/")
    suspend fun getCoinsTickers(
        @Query("start") start: Long? = null,
        @Query("limit") limit: Long? = null,
    ): Response<CoinsTickersResponse>

    @GET("api/ticker/")
    suspend fun getCoinTicker(
        @Query("id") id: Int
    ): Response<CoinTickerResponse>

    @GET("api/coin/markets")
    suspend fun getCoinMarkets(
        @Query("id") id: Int
    ): Response<CoinMarketsResponse>

    @GET("api/exchanges/")
    suspend fun getAllExchanges():Response<HashMap<String, ExchangesItems>>

    @GET("api/exchange/")
    suspend fun getExchange(
        @Query("id") id:Int
    ):Response<ExchangeItemResponse>

    @GET("api/coin/social_stats/")
    suspend fun getCoinSocialMedia(
        @Query("id") id:Int
    ):Response<CoinSocialMediaResponse>

}