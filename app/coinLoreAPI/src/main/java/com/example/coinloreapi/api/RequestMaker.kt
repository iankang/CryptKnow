package com.example.coinloreapi.api

import android.util.Log
import com.example.coinloreapi.models.CoinLoreResponse
import kotlinx.coroutines.*
import retrofit2.Response
import java.io.IOException


private val TAG: String = "RequestMaker"
suspend fun <T> coinLoreApiCall(
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    apiCall: suspend () -> Response<T>
): CoinLoreResponse<T> {
    return withContext(dispatcher) {
        try {
            val responseDeffered: Deferred<Response<T>> = async { apiCall.invoke() }
            val response = responseDeffered.await()
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
}
