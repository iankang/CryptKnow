package com.example.coinloreapi.repository

import android.util.Log
import com.example.coinloreapi.api.CoinLoreAPI

import com.example.coinloreapi.models.GlobalCoinResponse
import com.example.coinloreapi.utils.NetworkState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent.inject

import java.io.IOException

class GlobalCoinRepository {

    private val coinLoreAPI: CoinLoreAPI by inject(CoinLoreAPI::class.java)
    private val TAG = GlobalCoinRepository::class.java.name

    suspend fun getGlobalCoin(): NetworkState<GlobalCoinResponse> = withContext(Dispatchers.IO) {
        try {
            val responseDeffered = async { coinLoreAPI.getGlobalCoinData() }
            val response = responseDeffered.await()
            Log.d(TAG, "response: ${response.raw()}")
            if (response.isSuccessful) {
                Log.d(TAG, "success")
                NetworkState.Success(response.body()!!)
            } else {
                Log.e(TAG, "error: ${response}")
                when (response.code()) {
                    403 -> NetworkState.HttpErrors.ResourceForbidden(response.message())
                    404 -> NetworkState.HttpErrors.ResourceNotFound(response.message())
                    500 -> NetworkState.HttpErrors.InternalServerError(response.message())
                    502 -> NetworkState.HttpErrors.BadGateway(response.message())
                    301 -> NetworkState.HttpErrors.ResourceRemoved(response.message())
                    302 -> NetworkState.HttpErrors.RemovedResourceFound(response.message())
                    else -> NetworkState.Error(response.raw().toString())
                }


            }

        } catch (error: IOException) {
            NetworkState.NetworkException(error.localizedMessage ?: "error")
        }
    }
}

