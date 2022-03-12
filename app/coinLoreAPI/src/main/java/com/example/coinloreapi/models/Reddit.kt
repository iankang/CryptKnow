package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class Reddit(
    @SerializedName("avg_active_users")
    var avgActiveUsers: Double? = null,
    @SerializedName("subscribers")
    var subscribers: Int? = null
)