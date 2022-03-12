package com.example.coinloreapi.repository

import com.example.coinloreapi.api.CoinLoreAPIRequests
import com.example.coinloreapi.api.coinLoreApiCall
import com.example.coinloreapi.models.*
import org.koin.java.KoinJavaComponent.inject

class CoinLoreApi {

    private val coinLoreAPIRequests: CoinLoreAPIRequests by inject(CoinLoreAPIRequests::class.java)
    private val TAG = CoinLoreApi::class.java.name


    suspend fun getGlobalCoinResponse(): CoinLoreResponse<GlobalCoinResponse> {
        return coinLoreApiCall(apiCall = { coinLoreAPIRequests.getGlobalCoinData() })
    }

    suspend fun getCoinsTickers(
        start: Long? = null,
        limit: Long? = null
    ): CoinLoreResponse<CoinsTickersResponse> {
        return coinLoreApiCall { coinLoreAPIRequests.getCoinsTickers(start = start, limit = limit) }
    }

    suspend fun getCoinTicker(id: Int): CoinLoreResponse<CoinTickerResponse> {
        return coinLoreApiCall { coinLoreAPIRequests.getCoinTicker(id = id) }
    }

    suspend fun getCoinMarkets(id: Int): CoinLoreResponse<CoinMarketsResponse> {
        return coinLoreApiCall { coinLoreAPIRequests.getCoinMarkets(id = id) }
    }


    suspend fun getAllExchanges(): CoinLoreResponse<HashMap<String,ExchangesItems>> {
        return coinLoreApiCall { coinLoreAPIRequests.getAllExchanges() }
    }

    suspend fun getExchange(id:Int): CoinLoreResponse<ExchangeItemResponse>{
        return coinLoreApiCall { coinLoreAPIRequests.getExchange(id) }
    }

    suspend fun getCoinSocialMedia(id: Int):CoinLoreResponse<CoinSocialMediaResponse>{
        return coinLoreApiCall { coinLoreAPIRequests.getCoinSocialMedia(id) }
    }
}

