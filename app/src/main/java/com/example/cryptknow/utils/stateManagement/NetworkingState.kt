package com.example.cryptknow.utils.stateManagement

import android.util.Log
import com.example.coinloreapi.utils.NetworkState

object NetworkingState {
    fun <T> networkUiState(response: NetworkState<T>): NetworkUIState<T> {
        val TAG: String = "networkUIState"
        return when (response) {
            is NetworkState.Success -> {
                Log.d(TAG, response.data.toString())
                NetworkUIState(
                    response = response.data,
                    isSuccessful = true,
                    loading = false
                )
            }
            is NetworkState.HttpErrors.ResourceForbidden -> {
                Log.e("Preview", response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )

            }
            is NetworkState.HttpErrors.ResourceNotFound -> {
                Log.e(TAG, response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )


            }
            is NetworkState.HttpErrors.InternalServerError -> {
                Log.e(TAG, response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )


            }
            is NetworkState.HttpErrors.BadGateway -> {
                Log.e(TAG, response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )


            }
            is NetworkState.HttpErrors.ResourceRemoved -> {
                Log.e(TAG, response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )


            }
            is NetworkState.HttpErrors.RemovedResourceFound -> {
                Log.e(TAG, response.exception)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.exception
                )


            }
            is NetworkState.InvalidData -> {
                Log.e(TAG, "invalid Data")
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = "Invalid Data"
                )

            }
            is NetworkState.Error -> {
                Log.e(TAG, response.error)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.error
                )

            }
            is NetworkState.NetworkException -> {
                Log.e(TAG, response.error)
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = response.error
                )

            }
            else -> {
                Log.e(TAG, "unknown error")
                NetworkUIState(
                    response = null,
                    isSuccessful = false,
                    throwError = true,
                    loading = false,
                    error = "unknown error"
                )

            }
        }
    }
}