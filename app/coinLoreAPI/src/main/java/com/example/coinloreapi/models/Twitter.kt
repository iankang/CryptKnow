package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class Twitter(
    @SerializedName("followers_count")
    var followersCount: Int? = null,
    @SerializedName("status_count")
    var statusCount: Int? = null
)