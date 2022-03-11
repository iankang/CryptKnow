package com.example.coinloreapi.utils

sealed class NetworkState<T>{
    data class Success<T>(val data: T): NetworkState<T>()
    data class Error<T>(val error:String): NetworkState<T>()
    data class NetworkException<T>(val error: String): NetworkState<T>()
    data class InvalidData<T>(val empty:String?) :NetworkState<T>()
    sealed class HttpErrors<T>: NetworkState<T>(){
        data class ResourceForbidden<T>(val exception:String):HttpErrors<T>()
        data class ResourceNotFound<T>(val exception:String):HttpErrors<T>()
        data class InternalServerError<T>(val exception:String):HttpErrors<T>()
        data class BadGateway<T>(val exception:String):HttpErrors<T>()
        data class ResourceRemoved<T>(val exception:String):HttpErrors<T>()
        data class RemovedResourceFound<T>(val exception:String):HttpErrors<T>()
    }
}

