package com.example.cryptknow.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.produceState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.coinloreapi.models.CoinLoreResponse
import com.example.coinloreapi.models.GlobalCoinResponse
import com.example.coinloreapi.repository.GlobalCoinRepository

@Composable
fun HomeItems(coinRepository: GlobalCoinRepository){

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val coinState by produceState(initialValue = CoinLoreResponse<GlobalCoinResponse>() ){
            val response = coinRepository.getGlobalCoinResponse()
            value = response
        }
        if(coinState.isOk == false){
            Text(text = "loading")
        }

        if(coinState.isOk == true){
            Text(
                coinState.data.toString()
            )
        }

    }

}