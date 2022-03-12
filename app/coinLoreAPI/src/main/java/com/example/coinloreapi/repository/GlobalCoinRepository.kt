package com.example.coinloreapi.repository

import android.util.Log
import com.example.coinloreapi.api.CoinLoreAPI
import com.example.coinloreapi.api.coinLoreApiCall
import com.example.coinloreapi.models.CoinLoreResponse
import com.example.coinloreapi.models.GlobalCoinResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject
import retrofit2.Response
import java.io.IOException

class GlobalCoinRepository {

    private val coinLoreAPI: CoinLoreAPI by inject(CoinLoreAPI::class.java)
    private val TAG = GlobalCoinRepository::class.java.name

    suspend fun getGlobalCoin(): CoinLoreResponse<GlobalCoinResponse> =
        withContext(Dispatchers.IO) {
            try {
                val responseDeffered = async { coinLoreAPI.getGlobalCoinData() }
                val response: Response<GlobalCoinResponse> = responseDeffered.await()
                Log.d(TAG, "response: ${response.raw()}")
                if (response.isSuccessful) {
                    Log.d(TAG, "success")
                    CoinLoreResponse(
                        data = response.body(),
                        message = "successful",
                        isOk = true,
                        httpStatus = response.code()
                    )
                } else {
                    Log.e(TAG, "error: ${response}")
                    CoinLoreResponse(
                        data = response.body(),
                        message = response.errorBody().toString(),
                        isOk = false,
                        httpStatus = response.code()
                    )
                }

            } catch (error: IOException) {

                CoinLoreResponse(message = error.localizedMessage)
            }
        }

    suspend fun getGlobalCoinResponse():CoinLoreResponse<GlobalCoinResponse>{
        return coinLoreApiCall(apiCall = {coinLoreAPI.getGlobalCoinData()})
    }

}

