package com.example.coinloreapi.models


import com.google.gson.annotations.SerializedName

data class CoinSocialMediaResponse(
    @SerializedName("reddit")
    var reddit: Reddit? = null,
    @SerializedName("twitter")
    var twitter: Twitter? = null
)